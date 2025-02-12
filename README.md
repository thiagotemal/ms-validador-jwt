echo "# JWT Validator Microservice

## Descrição
Este microserviço valida tokens JWT com regras específicas de segurança, verificando a integridade e conformidade dos tokens.

## Requisitos de Validação do JWT
- Token deve ser um JWT válido
- Deve conter exatamente 3 claims: Name, Role e Seed
- Regras específicas para cada claim:
  - \`Name\`: 
    - Não pode conter números
    - Máximo de 256 caracteres
  - \`Role\`: 
    - Valores permitidos: \"Admin\", \"Member\" ou \"External\"
  - \`Seed\`: 
    - Deve ser um número primo

## Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- OpenTelemetry
- JWT Authentication (Auth0)
- Logback
- Maven

## Pré-requisitos
- JDK 17
- Maven
- Docker (opcional)

## Executando o Projeto

### Localmente
1. Clone o repositório
\`\`\`bash
git clone https://github.com/seu-usuario/ms-validador-jwt.git
cd ms-validador-jwt
\`\`\`

2. Compilar o projeto
\`\`\`bash
mvn clean package
\`\`\`

3. Executar a aplicação
\`\`\`bash
java -jar target/ms-validador-jwt-1.0.1-SNAPSHOT.jar
\`\`\`

### Com Docker
1. Construir a imagem
\`\`\`bash
docker build -t ms-validador-jwt .
\`\`\`

2. Executar o container
\`\`\`bash
docker run -p 8080:8080 ms-validador-jwt
\`\`\`

## Endpoint de Validação
- **GET** \`/validate\`
  - Parâmetro: Token JWT
  - Retorna: Booleano indicando validade do token

## Exemplo de Uso
\`\`\`bash
curl -X GET \"http://localhost:8080/validate?token=seu_token_jwt\"
\`\`\`

## Monitoramento
- Métricas disponíveis em \`/actuator/metrics\`
- Health check em \`/actuator/health\`
- Rastreamento distribuído com Zipkin

## Casos de Teste de Validação JWT

### Caso 1: Token Válido
- **Token de Entrada**: 
  \`\`\`
  eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg
  \`\`\`
- **Resultado Esperado**: \`verdadeiro\`
- **Justificativa**: 
  - Claims válidas
  - Role: \"Admin\"
  - Seed: \"7841\" (número primo)
  - Name: \"Toninho Araujo\" (sem números)

### Caso 2: Token Inválido - Estrutura Corrompida
- **Token de Entrada**: 
  \`\`\`
  eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg
  \`\`\`
- **Resultado Esperado**: \`falso\`
- **Justificativa**: JWT inválido (estrutura corrompida)

### Caso 3: Token Inválido - Nome com Números
- **Token de Entrada**: 
  \`\`\`
  eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs
  \`\`\`
- **Resultado Esperado**: \`falso\`
- **Justificativa**: 
  - Nome contém número (\"M4ria\")
  - Viola regra de nome sem caracteres numéricos

### Caso 4: Token Inválido - Claims Extras
- **Token de Entrada**: 
  \`\`\`
  eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY
  \`\`\`
- **Resultado Esperado**: \`falso\`
- **Justificativa**: 
  - Possui claim extra \"Org\"
  - Mais de 3 claims no token

## Validação Detalhada

A validação do token JWT segue as seguintes regras:
1. Verificação da assinatura JWT
2. Contagem de claims (exatamente 3)
3. Validação da claim \`Role\`
   - Valores permitidos: \"Admin\", \"Member\", \"External\"
4. Validação da claim \`Name\`
   - Sem caracteres numéricos
   - Máximo 256 caracteres
5. Validação da claim \`Seed\`
   - Deve ser um número primo

## Contribuição
1. Faça um fork do projeto
2. Crie sua feature branch (\`git checkout -b feature/nova-feature\`)
3. Commit suas mudanças (\`git commit -m 'Adiciona nova feature'\`)
4. Push para a branch (\`git push origin feature/nova-feature\`)
5. Abra um Pull Request

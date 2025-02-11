package br.com.temal.sec.tokenvalidator.config;

import br.com.temal.sec.tokenvalidator.repository.ClaimsRepository;
import br.com.temal.sec.tokenvalidator.repository.ClaimsRepositoryImpl;
import br.com.temal.sec.tokenvalidator.service.GetClaimsForbiddenService;
import br.com.temal.sec.tokenvalidator.service.GetGetClaimsForbiddenServiceImpl;
import br.com.temal.sec.tokenvalidator.service.ValidateJWTService;
import br.com.temal.sec.tokenvalidator.service.ValidateJWTServiceImpl;
import br.com.temal.sec.tokenvalidator.service.validation.*;
import br.com.temal.sec.tokenvalidator.util.ExtractClaims;
import br.com.temal.sec.tokenvalidator.util.ExtractClaimsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public ValidateJWTService validateJWTService(ClaimsTokenValidatorComponent claimsTokenValidatorComponent) {
        return new ValidateJWTServiceImpl(claimsTokenValidatorComponent);
    }

    @Bean
    public ClaimsTokenValidatorComponent claimsTokenValidatorComponent(ExtractClaims claimsExtractorImpl, PrimeNumberVerifierComponent primeNumberVerifierComponent, ClaimsTokenRuleValidatorComponent claimsTokenRuleValidatorComponent, ClaimsTokenDefinitionValidatorComponent claimsTokenDefinitionValidatorComponent) {
        return new ClaimsTokenValidatorComponentImpl(claimsExtractorImpl, primeNumberVerifierComponent, claimsTokenRuleValidatorComponent, claimsTokenDefinitionValidatorComponent);
    }

    @Bean
    public ExtractClaims extractClaims() {
        return new ExtractClaimsImpl();
    }

    @Bean
    public PrimeNumberVerifierComponent primeNumberVerifierComponent() {
        return new PrimeNumberValidatorImplComponent();
    }

    @Bean
    public ClaimsTokenRuleValidatorComponent claimsTokenRuleValidatorComponent(ExtractClaims extractClaims, GetClaimsForbiddenService getClaimsForbiddenService) {
        return new ClaimsTokenRuleValidatorComponentImpl(extractClaims, getClaimsForbiddenService);
    }

    @Bean
    public ClaimsTokenDefinitionValidatorComponent claimsTokenDefinitionValidatorComponent(ExtractClaimsImpl claimsExtractorImpl) {
        return new ClaimsTokenDefinitionValidatorComponentImpl(claimsExtractorImpl);
    }

    @Bean
    public GetClaimsForbiddenService getClaimsForbiddenService(ClaimsRepository claimsRepository){
        return new GetGetClaimsForbiddenServiceImpl(claimsRepository);
    }

    @Bean
    public ClaimsRepository claimsRepository(){
        return new ClaimsRepositoryImpl();
    }

}

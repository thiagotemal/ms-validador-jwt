package br.com.temal.sec.tokenvalidator.service.validation;

public interface ClaimsTokenDefinitionValidatorComponent {
    boolean isValid(String token);
}

package br.com.temal.sec.tokenvalidator.application.ports.in.validation;

public interface ClaimsTokenDefinitionValidator {
    boolean isValid(String token);
}

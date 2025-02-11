package br.com.temal.sec.tokenvalidator.service.validation;

public interface ClaimsTokenValidatorComponent {
    boolean isValid(String token);
}
package br.com.temal.sec.tokenvalidator.service.validation;

public interface ClaimsTokenRuleValidatorComponent {

    boolean isValid(String token);
}

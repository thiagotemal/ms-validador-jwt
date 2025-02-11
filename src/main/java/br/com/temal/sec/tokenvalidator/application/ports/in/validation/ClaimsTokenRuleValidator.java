package br.com.temal.sec.tokenvalidator.application.ports.in.validation;

public interface ClaimsTokenRuleValidator {

    boolean isValid(String token);
}

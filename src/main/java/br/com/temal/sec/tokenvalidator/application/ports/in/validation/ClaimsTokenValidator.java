package br.com.temal.sec.tokenvalidator.application.ports.in.validation;

public interface ClaimsTokenValidator {
    boolean isValid(String token);
}
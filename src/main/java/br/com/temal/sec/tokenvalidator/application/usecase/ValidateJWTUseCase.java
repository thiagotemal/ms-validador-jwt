package br.com.temal.sec.tokenvalidator.application.usecase;

import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenValidator;
import br.com.temal.sec.tokenvalidator.application.ports.in.ValidateJWTPort;

public class ValidateJWTUseCase implements ValidateJWTPort {

    private final ClaimsTokenValidator claimsTokenValidator;


    public ValidateJWTUseCase(ClaimsTokenValidator claimsTokenValidator  ){
        this.claimsTokenValidator = claimsTokenValidator;
    }

    public boolean isValid(String token) {
        return claimsTokenValidator.isValid(token);
    }
}

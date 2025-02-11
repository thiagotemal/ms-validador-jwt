package br.com.temal.sec.tokenvalidator.service;

import br.com.temal.sec.tokenvalidator.model.Token;
import br.com.temal.sec.tokenvalidator.service.validation.ClaimsTokenValidatorComponent;

public class ValidateJWTServiceImpl implements ValidateJWTService {

    private final ClaimsTokenValidatorComponent claimsTokenValidatorComponent;


    public ValidateJWTServiceImpl(ClaimsTokenValidatorComponent claimsTokenValidatorComponent){
        this.claimsTokenValidatorComponent = claimsTokenValidatorComponent;
    }

    public boolean isValid(Token token) {
        return this.claimsTokenValidatorComponent.isValid(token.getToken());
    }

}

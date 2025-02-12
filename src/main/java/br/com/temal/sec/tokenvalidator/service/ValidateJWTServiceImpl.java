package br.com.temal.sec.tokenvalidator.service;

import org.slf4j.LoggerFactory;

import br.com.temal.sec.tokenvalidator.model.Token;
import br.com.temal.sec.tokenvalidator.service.validation.ClaimsTokenValidatorComponent;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class ValidateJWTServiceImpl implements ValidateJWTService {

    private final ClaimsTokenValidatorComponent claimsTokenValidatorComponent;
    private static final Logger logger = LoggerFactory.getLogger(ValidateJWTServiceImpl.class);


    public ValidateJWTServiceImpl(ClaimsTokenValidatorComponent claimsTokenValidatorComponent){
        this.claimsTokenValidatorComponent = claimsTokenValidatorComponent;
    }

    public boolean isValid(Token token) {
        try {
            
            return this.claimsTokenValidatorComponent.isValid(token.getToken());
 
        } catch (Exception e) {
            logger.error("Error validating JWT", e);
            throw new RuntimeException("Error validating JWT", e);
        }
   }

}

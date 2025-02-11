package br.com.temal.sec.tokenvalidator.service;

import br.com.temal.sec.tokenvalidator.model.Token;
import br.com.temal.sec.tokenvalidator.model.TokenJWT;

public interface ValidateJWTService {
     boolean isValid(Token token);
}

package br.com.temal.sec.tokenvalidator.service;

import br.com.temal.sec.tokenvalidator.model.Token;

public interface ValidateJWTService {
     boolean isValid(Token token);
}

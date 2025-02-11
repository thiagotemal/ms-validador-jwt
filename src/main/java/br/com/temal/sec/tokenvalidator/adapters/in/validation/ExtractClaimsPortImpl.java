package br.com.temal.sec.tokenvalidator.adapters.in.validation;

import br.com.temal.sec.tokenvalidator.application.ports.in.ExtractClaimsPort;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

public class ExtractClaimsPortImpl implements ExtractClaimsPort {
    @Override
    public Map<String, Claim> extractClaims(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaims();

    }
}
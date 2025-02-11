package br.com.temal.sec.tokenvalidator.util;



import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Claim;

public class ExtractClaimsImpl implements ExtractClaims {
    @Override
    public Map<String, Claim> extractClaims(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaims();

    }
    public void extract(){

    }
}
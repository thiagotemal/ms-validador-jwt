package br.com.temal.sec.tokenvalidator.application.ports.in;

import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public interface ExtractClaimsPort {
    Map<String, Claim> extractClaims(String token);
}
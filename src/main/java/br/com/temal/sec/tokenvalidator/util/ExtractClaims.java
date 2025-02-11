package br.com.temal.sec.tokenvalidator.util;

import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public interface ExtractClaims {
    Map<String, Claim> extractClaims(String token);
}
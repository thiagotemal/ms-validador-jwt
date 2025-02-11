package br.com.temal.sec.tokenvalidator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.*;

public class CustomTokenJWTValidator {

    public static boolean isTokenValid(String token) {
        try {
            return isTokenValidAndWithCorrectClaims(token);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


   private static Map<String, Claim>getClaimsMapFromToken(String token) {

       DecodedJWT jwt = JWT.decode(token);
       return jwt.getClaims();
    }

    private static boolean isTokenValidAndWithCorrectClaims(String token) {
        try {
            Map<String, Claim> obj = getClaimsMapFromToken(token);
            if (obj.size() != 3) {
                return false;
            }
            if (!obj.containsKey("Name") || !obj.containsKey("Role") || !obj.containsKey("Seed")) {
                return false;
            }
            String name = obj.get("Name").asString();
            if (name.length() > 256 || name.matches(".*\\d.*")) {
                return false;
            }
            String role = obj.get("Role").asString();
            if (!Arrays.asList("Admin", "Member", "External").contains(role)) {
                return false;
            }
            int seed = obj.get("Seed").asInt();
            if (!isPrime(seed)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}


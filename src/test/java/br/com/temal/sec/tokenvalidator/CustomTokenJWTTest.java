package br.com.temal.sec.tokenvalidator;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Base64;

public class CustomTokenJWTTest {

    @Test
    public void testValidateTokenJWTObject() {
        //io.jsonwebtoken.io.Decoders decoder = new io.jsonwebtoken.io.Decoders();
       var token = "eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
        DecodedJWT jwt = JWT.decode(token);
        var claims = jwt.getClaims();
        JSONObject payload = new JSONObject(jwt.getPayload());
        System.out.println(payload);
    }

    // Add more test methods for other functions

}
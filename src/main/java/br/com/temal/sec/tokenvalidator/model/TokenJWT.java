package br.com.temal.sec.tokenvalidator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TokenJWT implements  Token{

    private String jwt;

    @Override
    public String getToken() {
        return jwt;
    }
}

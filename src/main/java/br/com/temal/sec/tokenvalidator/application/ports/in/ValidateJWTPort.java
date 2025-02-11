package br.com.temal.sec.tokenvalidator.application.ports.in;

public interface ValidateJWTPort {
     boolean isValid(String token);
}

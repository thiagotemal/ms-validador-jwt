package br.com.temal.sec.tokenvalidator.controller;

import br.com.temal.sec.tokenvalidator.model.TokenJWT;
import br.com.temal.sec.tokenvalidator.service.ValidateJWTService;
import br.com.temal.sec.tokenvalidator.service.ValidateJWTServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/jwt-tokens/valid")
public class Controller {
    private final ValidateJWTService validateJWTServiceImpl;

    public Controller(ValidateJWTService validateJWTService) {
        this.validateJWTServiceImpl = validateJWTService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public ResponseEntity<Boolean> validateJWT(@RequestHeader(value = "Authorization", required = true) String Authorization) {
        return ResponseEntity.ok().body(validateJWTServiceImpl.isValid(new TokenJWT(Authorization)));
    }
}


package br.com.temal.sec.tokenvalidator.adapters.in;

import br.com.temal.sec.tokenvalidator.application.usecase.ValidateJWTUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/jwt-tokens/valid")
public class Controller {
    private final ValidateJWTUseCase validateJWTUseCase;

    public Controller(ValidateJWTUseCase validateJWTUseCase) {
        this.validateJWTUseCase = validateJWTUseCase;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK, code = HttpStatus.OK)
    public ResponseEntity<Boolean> validateJWT(@RequestHeader(value = "Authorization", required = true) String Authorization) {
        return ResponseEntity.ok().body(validateJWTUseCase.isValid(Authorization));
    }
}


package br.com.temal.sec.tokenvalidator.adapters.in.validation;

import br.com.temal.sec.tokenvalidator.application.ports.in.ExtractClaimsPort;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenDefinitionValidator;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenRuleValidator;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenValidator;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.PrimeNumberVerifierValidator;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class ClaimsTokenValidatorImpl implements ClaimsTokenValidator {
    private final ExtractClaimsPort extractClaimsPort;

    private final PrimeNumberVerifierValidator primeNumberVerifierValidator;
    private final ClaimsTokenRuleValidator claimsTokenRuleValidator;
    private final ClaimsTokenDefinitionValidator claimsTokenDefinitionValidator;

    public ClaimsTokenValidatorImpl(ExtractClaimsPortImpl claimsExtractorImpl,
                                    PrimeNumberVerifierValidator primeNumberVerifierValidator,
                                    ClaimsTokenRuleValidator claimsTokenRuleValidator, ClaimsTokenDefinitionValidator claimsTokenDefinitionValidator) {
        this.extractClaimsPort = claimsExtractorImpl;
        this.primeNumberVerifierValidator = primeNumberVerifierValidator;
        this.claimsTokenRuleValidator = claimsTokenRuleValidator;
        this.claimsTokenDefinitionValidator = claimsTokenDefinitionValidator;
    }


    @Override
    public boolean isValid(String token) {
        try {
            Map<String, Claim> obj = extractClaimsPort.extractClaims(token);

            if(!claimsTokenDefinitionValidator.isValid(token)) {
                return false;
            }

            if(!primeNumberVerifierValidator.isPrime(obj.get("Seed").asInt())) {
                return false;
            }
            if(!claimsTokenRuleValidator.isValid(token)) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

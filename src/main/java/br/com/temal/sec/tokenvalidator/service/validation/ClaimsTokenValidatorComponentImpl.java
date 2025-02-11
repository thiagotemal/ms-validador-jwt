package br.com.temal.sec.tokenvalidator.service.validation;

import br.com.temal.sec.tokenvalidator.util.ExtractClaims;
import br.com.temal.sec.tokenvalidator.util.ExtractClaimsImpl;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class ClaimsTokenValidatorComponentImpl implements ClaimsTokenValidatorComponent {
    private final ExtractClaims extractClaims;

    private final PrimeNumberVerifierComponent primeNumberVerifierComponent;
    private final ClaimsTokenRuleValidatorComponent claimsTokenRuleValidatorComponent;
    private final ClaimsTokenDefinitionValidatorComponent claimsTokenDefinitionValidatorComponent;

    public ClaimsTokenValidatorComponentImpl(ExtractClaims claimsExtractorImpl,
                                             PrimeNumberVerifierComponent primeNumberVerifierComponent,
                                             ClaimsTokenRuleValidatorComponent claimsTokenRuleValidatorComponent, ClaimsTokenDefinitionValidatorComponent claimsTokenDefinitionValidatorComponent) {
        this.extractClaims = claimsExtractorImpl;
        this.primeNumberVerifierComponent = primeNumberVerifierComponent;
        this.claimsTokenRuleValidatorComponent = claimsTokenRuleValidatorComponent;
        this.claimsTokenDefinitionValidatorComponent = claimsTokenDefinitionValidatorComponent;
    }


    @Override
    public boolean isValid(String token) {
        try {
            Map<String, Claim> obj = extractClaims.extractClaims(token);

            if(!claimsTokenDefinitionValidatorComponent.isValid(token)) {
                return false;
            }

            if(!primeNumberVerifierComponent.isPrime(Integer.parseInt(obj.get("Seed").asString()))) {
                return false;
            }
            return claimsTokenRuleValidatorComponent.isValid(token);
        } catch (Exception e) {
            return false;
        }
    }
}

package br.com.temal.sec.tokenvalidator.adapters.in.validation;

import br.com.temal.sec.tokenvalidator.application.ports.ClaimsRepositoryPort;
import br.com.temal.sec.tokenvalidator.application.ports.in.ExtractClaimsPort;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenRuleValidator;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class ClaimsTokenRuleValidatorImpl implements ClaimsTokenRuleValidator {
    private final ExtractClaimsPort extractClaimsPort;
    private final ClaimsRepositoryPort claimsRepositoryPort;

    public ClaimsTokenRuleValidatorImpl(ExtractClaimsPortImpl claimsExtractorImpl, ClaimsRepositoryPort claimsRepositoryPort) {
        this.extractClaimsPort = claimsExtractorImpl;
        this.claimsRepositoryPort = claimsRepositoryPort;
    }

    @Override
    public boolean isValid(String token) {
        Map<String, Claim> obj = extractClaimsPort.extractClaims(token);

        String role = obj.get("Role").asString();
        return (!claimsRepositoryPort.getClaimsForbidden().contains(role)) ;

        }
    }


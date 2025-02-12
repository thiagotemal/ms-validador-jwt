package br.com.temal.sec.tokenvalidator.service.validation;

import java.util.Map;

import com.auth0.jwt.interfaces.Claim;

import br.com.temal.sec.tokenvalidator.service.GetClaimsForbiddenService;
import br.com.temal.sec.tokenvalidator.util.ExtractClaims;

public class ClaimsTokenRuleValidatorComponentImpl implements ClaimsTokenRuleValidatorComponent {
    private final ExtractClaims extractClaims;
    private final GetClaimsForbiddenService getClaimsForbiddenService;

    public ClaimsTokenRuleValidatorComponentImpl(ExtractClaims claimsExtractorImpl, GetClaimsForbiddenService getClaimsForbiddenService) {
        this.extractClaims = claimsExtractorImpl;
        this.getClaimsForbiddenService = getClaimsForbiddenService;
    }

    @Override
    public boolean isValid(String token) {
        Map<String, Claim> obj = extractClaims.extractClaims(token);

        String role = obj.get("Role").asString();
        return (!getClaimsForbiddenService.getClaimsForbidden().contains(role)) ;

        }
    }


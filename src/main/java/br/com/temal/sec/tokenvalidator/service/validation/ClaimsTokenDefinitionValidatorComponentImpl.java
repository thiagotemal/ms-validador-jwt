package br.com.temal.sec.tokenvalidator.service.validation;

import br.com.temal.sec.tokenvalidator.util.ExtractClaims;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class ClaimsTokenDefinitionValidatorComponentImpl implements ClaimsTokenDefinitionValidatorComponent {
    private final ExtractClaims extractClaims;

    public ClaimsTokenDefinitionValidatorComponentImpl(ExtractClaims extractClaims) {
        this.extractClaims = extractClaims;
    }

    @Override
    public boolean isValid(String token) {
        Map<String, Claim> obj = extractClaims.extractClaims(token);
        if (!obj.containsKey("Name") || !obj.containsKey("Role") || !obj.containsKey("Seed")) {
            return false;
        }
        if(extractClaims.extractClaims(token).size() != 3){
            return false;
        }
        String name = obj.get("Name").asString();
        return name.length() <= 256 && !name.matches(".*\\d.*");
    }
}

package br.com.temal.sec.tokenvalidator.adapters.in.validation;

import br.com.temal.sec.tokenvalidator.application.ports.in.ExtractClaimsPort;
import br.com.temal.sec.tokenvalidator.application.ports.in.validation.ClaimsTokenDefinitionValidator;
import com.auth0.jwt.interfaces.Claim;

import java.util.Map;

public class ClaimsTokenDefinitionValidatorImpl implements ClaimsTokenDefinitionValidator {
    private final ExtractClaimsPort extractClaimsPort;

    public ClaimsTokenDefinitionValidatorImpl(ExtractClaimsPort extractClaimsPort) {
        this.extractClaimsPort = extractClaimsPort;
    }

    @Override
    public boolean isValid(String token) {
        Map<String, Claim> obj = extractClaimsPort.extractClaims(token);
        if (!obj.containsKey("Name") || !obj.containsKey("Role") || !obj.containsKey("Seed")) {
            return false;
        }
        if(extractClaimsPort.extractClaims(token).size() != 3){
            return false;
        }
        String name = obj.get("Name").asString();
        return name.length() <= 256 && !name.matches(".*\\d.*");
    }
}

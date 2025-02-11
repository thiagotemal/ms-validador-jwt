package br.com.temal.sec.tokenvalidator.service;

import br.com.temal.sec.tokenvalidator.model.Claim;
import br.com.temal.sec.tokenvalidator.repository.ClaimsRepository;

import java.util.List;

public class GetGetClaimsForbiddenServiceImpl implements GetClaimsForbiddenService {
    private final ClaimsRepository claimsRepositoryImpl;
    private static final String CLAIM_FORBIDDEN = "Forbidden";

    public GetGetClaimsForbiddenServiceImpl(ClaimsRepository claimsRepository) {
        this.claimsRepositoryImpl = claimsRepository;
    }

    @Override
    public List<Claim> getClaimsForbidden() {

        return this.claimsRepositoryImpl.getClaimsByNameForbidden(CLAIM_FORBIDDEN);

    }
}

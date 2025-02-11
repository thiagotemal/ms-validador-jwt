package br.com.temal.sec.tokenvalidator.adapters.out;

import br.com.temal.sec.tokenvalidator.adapters.out.repository.ClaimsRepository;
import br.com.temal.sec.tokenvalidator.application.ports.ClaimsRepositoryPort;

import java.util.List;

public class GetClaimsForbiddenAdapter implements ClaimsRepositoryPort {
    private final ClaimsRepository claimsRepository;

    public GetClaimsForbiddenAdapter(ClaimsRepository claimsRepository) {
        this.claimsRepository = claimsRepository;
    }

    @Override
    public List<String> getClaimsForbidden() {
        return this.claimsRepository.getClaimsForbidden();
    }
}

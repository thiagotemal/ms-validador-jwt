package br.com.temal.sec.tokenvalidator.adapters.out.repository;

import java.util.List;

public class ClaimsRepository {

    public List<String> getClaimsForbidden() {
        return List.of("Admin", "Member", "External");
    }
}

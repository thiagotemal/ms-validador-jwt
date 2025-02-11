package br.com.temal.sec.tokenvalidator.repository;

import br.com.temal.sec.tokenvalidator.model.Claim;

import java.util.List;
import java.util.stream.Stream;

public class ClaimsRepositoryImpl implements ClaimsRepository{

    public List<Claim> getClaimsByNameForbidden(String name) {
        return Stream.of(
                new Claim("Role", "Admin", "Forbidden"),
                new Claim("Role", "Member", "Forbidden"),
                new Claim("Role", "External", "Forbidden")
        ).filter(c->c.getStatus().equals("Forbidden")).toList();
    }
}

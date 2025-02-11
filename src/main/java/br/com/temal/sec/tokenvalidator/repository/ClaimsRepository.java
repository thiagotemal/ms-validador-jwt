package br.com.temal.sec.tokenvalidator.repository;

import br.com.temal.sec.tokenvalidator.model.Claim;

import java.util.List;

public interface ClaimsRepository {
    List<Claim> getClaimsByNameForbidden(String name);
        }

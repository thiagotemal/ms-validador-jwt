package br.com.temal.sec.tokenvalidator.service;

import br.com.temal.sec.tokenvalidator.model.Claim;

import java.util.List;

public interface GetClaimsForbiddenService {
    List<Claim> getClaimsForbidden();
}

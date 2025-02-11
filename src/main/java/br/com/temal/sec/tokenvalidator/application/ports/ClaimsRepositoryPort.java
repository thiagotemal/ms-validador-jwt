package br.com.temal.sec.tokenvalidator.application.ports;

import java.util.List;

public interface ClaimsRepositoryPort {
    List<String> getClaimsForbidden();
}

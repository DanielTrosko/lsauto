package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.model.entites.Authorities;
import it.danieltrosko.lsauto.model.repositories.AuthoritiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesService {

    AuthoritiesRepository authoritiesRepository;

    public AuthoritiesService(AuthoritiesRepository authoritiesRepository) {
        this.authoritiesRepository = authoritiesRepository;
    }

    public List<Authorities> getauthoritiesByEmail(String email){
        return authoritiesRepository.getAuthoritiesByEmail(email);
    }
}

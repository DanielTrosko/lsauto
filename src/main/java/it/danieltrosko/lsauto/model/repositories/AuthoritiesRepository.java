package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {

    List<Authorities> getAuthoritiesByEmail(String email);
}

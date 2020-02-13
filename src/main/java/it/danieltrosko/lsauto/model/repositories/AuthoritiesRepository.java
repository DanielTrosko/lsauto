package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}

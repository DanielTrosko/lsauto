package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

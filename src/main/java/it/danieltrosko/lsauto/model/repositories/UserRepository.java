package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> getUserByEmail(String email);
   Optional<User> getUserByEmail(String email);
}

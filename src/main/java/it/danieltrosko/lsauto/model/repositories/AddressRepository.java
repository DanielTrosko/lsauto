package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

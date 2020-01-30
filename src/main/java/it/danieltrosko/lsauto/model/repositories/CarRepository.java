package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
    Optional<Car> getByPlateNumberEquals(String plateNr);
}

package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

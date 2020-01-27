package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairRepository extends JpaRepository<Repair, Long> {
}

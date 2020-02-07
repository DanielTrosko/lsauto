package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.RepairName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairNameRepository extends JpaRepository<RepairName, Long> {
}

package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> getAllByStatusIsNot(RepairStatus repairStatus);
}

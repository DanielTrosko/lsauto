package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> getAllByStatusIsNot(RepairStatus repairStatus);
    List<Repair> getAllByStatusIs(RepairStatus repairStatus);
    @Query(value = "SELECT r.date_of_admission, r.status, c.mark, c.model FROM repair r JOIN car c on r.id = car_id", nativeQuery = true)
    List<CurrentRepair> getallcos();
}

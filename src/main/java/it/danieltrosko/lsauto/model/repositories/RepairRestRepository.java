package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRestRepository extends JpaRepository<CurrentRepair, Long> {

    @Query(value = "SELECT c.id, c.mark, c.model, r.date_of_admission, r.estimated_repair_price FROM repair as r INNER JOIN car as c ON r.car_id=c.id WHERE r.status = 'ACCEPTED' ", nativeQuery = true)
    List<CurrentRepair> getReducedRepairData();


}

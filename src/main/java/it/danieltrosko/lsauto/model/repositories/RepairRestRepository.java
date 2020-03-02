package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRestRepository extends JpaRepository<CurrentRepair, Long> {
    @Query(value = "SELECT c.id, r.date_of_admission, r.estimated_repair_price, c.mark, c.model FROM repair r JOIN car c on r.id = car_id", nativeQuery = true)
    List<CurrentRepair> getReducedRepairData();
}

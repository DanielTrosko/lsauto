package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface RepairRepository extends JpaRepository<Repair, Long>{

    List<Repair> getAllByStatusIsNot(RepairStatus repairStatus);

    List<Repair> getAllByStatusIs(RepairStatus repairStatus);

}

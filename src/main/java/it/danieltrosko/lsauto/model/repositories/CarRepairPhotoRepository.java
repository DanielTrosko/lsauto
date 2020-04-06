package it.danieltrosko.lsauto.model.repositories;

import it.danieltrosko.lsauto.model.entites.CarRepairPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepairPhotoRepository extends JpaRepository<CarRepairPhoto, Long> {

    List<CarRepairPhoto> getAllByRepairId(Long id);
}

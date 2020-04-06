package it.danieltrosko.lsauto.services;

import it.danieltrosko.lsauto.dto.CarRepairPhotoDTO;
import it.danieltrosko.lsauto.mapper.CarRepairPhotoMapper;
import it.danieltrosko.lsauto.model.entites.CarRepairPhoto;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.repositories.CarRepairPhotoRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CarRepairPhotoService {

    private RepairRepository repairRepository;
    private CarRepairPhotoRepository carRepairPhotoRepository;

    public CarRepairPhotoService(RepairRepository repairRepository, CarRepairPhotoRepository carRepairPhotoRepository) {
        this.repairRepository = repairRepository;
        this.carRepairPhotoRepository = carRepairPhotoRepository;
    }


    public List<CarRepairPhotoDTO> getCarRepairPhotos(Long id) {
        List<CarRepairPhoto> carRepairPhotos = carRepairPhotoRepository.getAllByRepairId(id);
        return carRepairPhotos.stream().map(CarRepairPhotoMapper::toDTO).collect(Collectors.toList());
    }
    public void saveCarRepairPhotos(List<MultipartFile> files, Repair repair) throws IOException {
        for (int i = 0; i < files.size(); i++) {
            CarRepairPhoto carRepairPhoto = new CarRepairPhoto();
            carRepairPhoto.setRepair(repair);
            carRepairPhoto.setPhoto(files.get(i).getBytes());
            carRepairPhotoRepository.save(carRepairPhoto);
        }
    }

}

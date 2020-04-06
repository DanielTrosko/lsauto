package it.danieltrosko.lsauto.mapper;

import it.danieltrosko.lsauto.dto.CarRepairPhotoDTO;
import it.danieltrosko.lsauto.model.entites.CarRepairPhoto;

public class CarRepairPhotoMapper {


    public static CarRepairPhotoDTO toDTO(CarRepairPhoto carRepairPhoto) {
        CarRepairPhotoDTO carRepairPhotoDTO = new CarRepairPhotoDTO();
        carRepairPhotoDTO.setRepair(carRepairPhoto.getId());
        carRepairPhotoDTO.setPhoto(carRepairPhoto.getPhoto());
        carRepairPhotoDTO.setId(carRepairPhoto.getId());
        return carRepairPhotoDTO;
    }
}

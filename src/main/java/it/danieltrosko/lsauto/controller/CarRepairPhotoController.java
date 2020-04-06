package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.model.entites.CarRepairPhoto;
import it.danieltrosko.lsauto.model.repositories.CarRepairPhotoRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/photo")
public class CarRepairPhotoController {

    CarRepairPhotoRepository carRepairPhotoRepository;

    public CarRepairPhotoController(CarRepairPhotoRepository carRepairPhotoRepository) {
        this.carRepairPhotoRepository = carRepairPhotoRepository;
    }

    @GetMapping(value = "/show")
    @ResponseBody
    public ResponseEntity<Resource> loadPhoto(@RequestParam String id) {
        Long po = Long.parseLong(id);
        CarRepairPhoto carRepairPhoto = carRepairPhotoRepository.getOne(po);
        ByteArrayResource resource = new ByteArrayResource(carRepairPhoto.getPhoto());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(resource);
    }
}

package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRestRepository;
import it.danieltrosko.lsauto.services.CarAcceptanceService;
import it.danieltrosko.lsauto.services.RepairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/repair")
public class RepairRestController {

    private final RepairService repairService;
    private final CarAcceptanceService carAcceptanceService;


    public RepairRestController(RepairService repairService, CarAcceptanceService carAcceptanceService) {
        this.repairService = repairService;
        this.carAcceptanceService = carAcceptanceService;
    }

    @GetMapping
    public List<RepairDTO> getActualRepairCars(@RequestParam Map<String, String> parameters) {
        return repairService.getRepairListByParameters(parameters);
    }

    @PostMapping
    public ResponseEntity<?> addNewCarAcceptance
            (@RequestParam Map<String, String> map, MultipartFile photoOne,
             MultipartFile photoTwo, MultipartFile photoThree, MultipartFile photoFour) throws IOException {

        List<MultipartFile> multipartFiles = new ArrayList<>();
        multipartFiles.add(photoOne);
        multipartFiles.add(photoTwo);
        multipartFiles.add(photoThree);
        multipartFiles.add(photoFour);
        carAcceptanceService.createRepairWithPhotos(map, multipartFiles);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }


}



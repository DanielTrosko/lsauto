package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.model.entites.Repair;
import it.danieltrosko.lsauto.model.entites.RepairStatus;
import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import it.danieltrosko.lsauto.model.repositories.RepairRepository;
import it.danieltrosko.lsauto.model.repositories.RepairRestRepository;
import it.danieltrosko.lsauto.services.CarAcceptanceService;
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

    private RepairRestRepository repairRestRepository;
    private CarAcceptanceService carAcceptanceService;
    private RepairRepository repairRepository;

    public RepairRestController(RepairRestRepository repairRestRepository, CarAcceptanceService carAcceptanceService, RepairRepository repairRepository) {
        this.repairRestRepository = repairRestRepository;
        this.carAcceptanceService = carAcceptanceService;
        this.repairRepository = repairRepository;
    }

    @GetMapping(value = "/getactualrepaircars")
    public List<CurrentRepair> getActualRepairCars(){
        return repairRestRepository.getReducedRepairData();
    }

    @GetMapping(value = "/getactualrepaircarss")
    public List<Repair> getActualRepairCarss(){
        return repairRepository.getAllByStatusIs(RepairStatus.REPAIR);
    }


    @GetMapping(value = "/")
    public List<Repair> getActualRepairCarsss(@ModelAttribute("RepairRequestParameters") RepairRequestParameters paramteres) {

        return repairRepository.getAllByStatusIs(paramteres.status);
    }


    @PostMapping(value = "/addnewcaracceptance")
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

    @PostMapping(value = "/addnewacceptance")
    public ResponseEntity<?> addNewAcceptance(@Valid @ModelAttribute("CarAcceptanceDTO") CarAcceptanceDTO carAcceptanceDTO) {
        carAcceptanceService.createAcceptance(carAcceptanceDTO);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}



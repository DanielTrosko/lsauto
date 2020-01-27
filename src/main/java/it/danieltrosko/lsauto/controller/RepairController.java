package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.services.RepairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/repair")
public class RepairController {

    private RepairService repairService;

    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }


    @GetMapping(value = "/getrepairbyid")
    public RepairDTO getRepairById(Long id) {
        return repairService.getRepairById(id);
    }

    @PostMapping(value = "/addnewrepair")
    public ResponseEntity<Void> addNewRepair(@Valid @ModelAttribute("RepairDTO") RepairDTO repairDTO) {
        if (repairDTO.getId() == null) {
            repairService.createRepair(repairDTO);
        } else {
            repairService.updateRepair(repairDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

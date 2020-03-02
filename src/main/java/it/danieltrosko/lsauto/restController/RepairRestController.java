package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.model.entites.rest.CurrentRepair;
import it.danieltrosko.lsauto.model.repositories.RepairRestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/api/repair")
public class RepairRestController {

    private RepairRestRepository repairRestRepository;


    public RepairRestController(RepairRestRepository repairRestRepository) {
        this.repairRestRepository = repairRestRepository;
    }

    @GetMapping(value = "/getactualrepaircars")
    public List<CurrentRepair> getActualRepairCars(){
        return repairRestRepository.getReducedRepairData();
    }
}

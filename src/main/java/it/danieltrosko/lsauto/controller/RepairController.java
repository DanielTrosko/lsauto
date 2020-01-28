package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.services.CarService;
import it.danieltrosko.lsauto.services.RepairService;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/repair")
public class RepairController {

    private RepairService repairService;
    private CarService carService;
    private UserService userService;

    public RepairController(RepairService repairService, CarService carService, UserService userService) {
        this.repairService = repairService;
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping(value = "/getrepairbyid")
    public RepairDTO getRepairById(Long id) {
        return repairService.getRepairById(id);
    }

    @PostMapping(value = "/addnewrepair")
    public String addNewRepair(@Valid @ModelAttribute("RepairDTO") RepairDTO repairDTO) {
        if (repairDTO.getId() == null) {
//            repairService.createRepair(repairDTO);
        } else {
//            repairService.updateRepair(repairDTO);
        }
        return "index";
    }

    @GetMapping(value = "/currentrepairs")
    public String currentRepair(Model model) {
        model.addAttribute("currentrepair", repairService.getCurrentRepair());
        return "current_repairs";
    }

    @GetMapping(value = "/addrepair")
    public String addRepair(@RequestParam(value = "id", required = false) Long id, Model model) {

        if (id != null) {
            model.addAttribute("repair", repairService.getExistCarAcceptance(id));
            return "/repair/add_new_repair";
        } else {
            model.addAttribute("repair", new CarAcceptanceDTO());
            return "/repair/add_new_repair";
        }
    }

}

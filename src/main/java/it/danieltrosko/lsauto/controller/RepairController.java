package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.services.CarAcceptanceService;
import it.danieltrosko.lsauto.services.CarService;
import it.danieltrosko.lsauto.services.RepairService;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/repair")
public class RepairController {

    private RepairService repairService;
    private CarService carService;
    private UserService userService;
    private CarAcceptanceService carAcceptanceService;

    public RepairController(RepairService repairService, CarService carService, UserService userService, CarAcceptanceService carAcceptanceService) {
        this.repairService = repairService;
        this.carService = carService;
        this.userService = userService;
        this.carAcceptanceService = carAcceptanceService;
    }


    @PostMapping(value = "/addnewrepair")
    public String addNewRepair(@Valid @ModelAttribute("RepairDTO") RepairDTO repairDTO) {
        if (repairDTO.getId() == null) {
            repairService.createRepair(repairDTO);
        } else {
            repairService.updateRepair(repairDTO);
        }
        return "redirect:/repair/currentrepairs";
    }

    @GetMapping(value = "/currentrepairs")
    public String currentRepair(Model model) {
        model.addAttribute("currentrepairs", repairService.getCurrentRepair());
        return "/repair/current_repairs";
    }

    @GetMapping(value = "/getonerepair")
    public String getOneRepair(@RequestParam(value = "id") Long id, Model model){
        model.addAttribute("repair", repairService.getRepairById(id));
        return "/repair/edit_repair";
    }



    @GetMapping(value = "/addrepair")
    public String addRepair(@RequestParam(value = "id", required = false) Optional<Long> id, Model model) {

        if (id.isPresent()) {
            model.addAttribute("repair", repairService.getExistCarAcceptance(id.get()));
        } else {
            model.addAttribute("repair", new CarAcceptanceDTO());
        }
        return "/repair/add_new_repair";
    }

    @PostMapping(value = "/addnewacceptance")
    public String addNewAcceptance(@Valid @ModelAttribute("CarAcceptanceDTO") CarAcceptanceDTO carAcceptanceDTO) {
        carAcceptanceService.createAcceptance(carAcceptanceDTO);
        return "/repair/current_repairs";
    }

}

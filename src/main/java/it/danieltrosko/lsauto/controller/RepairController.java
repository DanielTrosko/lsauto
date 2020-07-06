package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarAcceptanceDTO;
import it.danieltrosko.lsauto.dto.RepairDTO;
import it.danieltrosko.lsauto.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/repair")
public class RepairController {

    private final RepairService repairService;
    private final CarAcceptanceService carAcceptanceService;
    private final CarRepairPhotoService carRepairPhotoService;


    public RepairController(RepairService repairService, CarAcceptanceService carAcceptanceService, CarRepairPhotoService carRepairPhotoService) {
        this.repairService = repairService;
        this.carAcceptanceService = carAcceptanceService;
        this.carRepairPhotoService = carRepairPhotoService;
    }

    @PostMapping(value = "/addnewrepair")
    public String addNewRepair(@Valid @ModelAttribute("RepairDTO") RepairDTO repairDTO, Model model) {
        if (repairDTO.getId() == null) {
            return "redirect:currentrepairs";
        } else {
            repairService.updateRepair(repairDTO);
            model.addAttribute("status", "Naprawa " + repairDTO.getRepairNumber() + " została zaktualizowana");
            model.addAttribute("currentrepairs", repairService.getCurrentRepair());

        }
        return "repair/current_repairs";
    }

    @GetMapping
    public String getRepairs(@RequestParam Map<String, String> parameters, Model model) {
        model.addAttribute("currentrepairs", repairService.getRepairListByParameters(parameters));
        return "repair/current_repairs";
    }

    @GetMapping(value = "/{id}")
    public String getOneRepair(@PathVariable("id") Long id, Model model) {
        model.addAttribute("repair", repairService.getRepairById(id));
        return "repair/edit_repair";
    }


    @GetMapping(value = "/addrepair")
    public String addRepair(@RequestParam(value = "id", required = false) Optional<Long> id, Model model) {

        if (id.isPresent()) {
            model.addAttribute("repair", repairService.getExistCarAcceptance(id.get()));
        } else {
            model.addAttribute("repair", new CarAcceptanceDTO());
        }
        return "repair/add_new_repair";
    }

    @GetMapping(value = "/addrepairtoexistcar")
    public String addRepairToExistCar(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("acceptance", repairService.getAcceptanceCarWithExistCar(id));
        return "repair/add_new_repair_to_exist_car";
    }

    @PostMapping(value = "/addnewacceptance")
    public String addNewAcceptance(@Valid @ModelAttribute("CarAcceptanceDTO") CarAcceptanceDTO carAcceptanceDTO) {
        carAcceptanceService.createAcceptance(carAcceptanceDTO);
        return "redirect:/repair/currentrepairs";
    }

    @GetMapping(value = "/repairhistory")
    public String getHistoryOfRepair(Model model) {
        model.addAttribute("history", repairService.getRepairHistory());
        return "repair/history_repair";
    }

    @GetMapping(value = "/photo/{id}")
    public String showCarRepairPhotos(@PathVariable("id") Long id, Model model) {
        model.addAttribute("photos", carRepairPhotoService.getCarRepairPhotos(id));
        return "repair/car_repair_photos";
    }

}

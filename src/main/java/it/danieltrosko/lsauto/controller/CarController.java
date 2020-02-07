package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {
    private CarService carService;
    private UserService userService;

    public CarController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }


    @GetMapping(value = "/getcarbyid")
    public CarDTO getCarById(Long id) {
        return carService.getCarById(id);
    }


    @GetMapping(value = "/addnewcar")
    public String addNewCar(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("car", new CarDTO());
        } else {
            model.addAttribute("car", carService.getCarById(id));
        }
        model.addAttribute("users", userService.getAllUser());
        return "car/add_new_car";
    }


    @PostMapping(value = "/createnewcar")
    public String createCar(@Valid @ModelAttribute("CarDTO") CarDTO carDTO, Model model) {
        if (carDTO.getId() == null) {
            carService.createCar(carDTO);
        } else {
            carService.createCar(carDTO);
        }
        model.addAttribute("carlist", carService.getAllCars());
        return "index";
    }

    @GetMapping(value = "/showcar")
    public String showCar(@RequestParam("id") Long id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        return "car/show_car";
    }

}

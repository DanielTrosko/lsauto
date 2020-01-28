package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String addNewCar(Model model) {
        model.addAttribute("car", new CarDTO());
        model.addAttribute("users", userService.getAllUser());
        return "/car/add_new_car";
    }


    @PostMapping(value = "/createnewcar")
    public String createCar(@Valid @ModelAttribute("CarDTO") CarDTO carDTO) {
        if (carDTO.getId() == null) {
            carService.createCar(carDTO);
        } else {
            carService.createCar(carDTO);
        }
        return "index";
    }


}

package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }



    @GetMapping()
    public String addNewCar(@RequestParam(value = "id", required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("car", new CarDTO());
        } else {
            model.addAttribute("car", carService.getCarById(id));
        }
        return "car/add_new_car";
    }


    @PostMapping()
    public String createCar(@Valid @ModelAttribute("CarDTO") CarDTO carDTO, Model model) {
        if (carDTO.getId() == null) {
            carService.createCar(carDTO);
        } else {
            carService.createCar(carDTO);
        }
        model.addAttribute("carlist", carService.getCarsList());
        return "index";
    }

    @GetMapping(value = "/{id}")
    public String showCar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        return "car/show_car";
    }

}

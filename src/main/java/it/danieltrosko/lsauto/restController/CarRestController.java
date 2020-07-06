package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/car/android")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDTO> getCarsList(@RequestParam Map<String, String> parameters){
        return carService.getCarsList(parameters);
    }
}

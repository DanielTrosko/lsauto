package it.danieltrosko.lsauto.restController;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/car")
public class CarRestController {
    private CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/getallcars")
    public List<CarDTO> getAllCars(){
        return carService.getAllCars();
    }
}

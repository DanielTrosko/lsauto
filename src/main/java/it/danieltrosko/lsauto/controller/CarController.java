package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.CarDTO;
import it.danieltrosko.lsauto.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/getcarbyid")
    public CarDTO getCarById(Long id) {
        return carService.getCarById(id);
    }


    @PostMapping(value = "/createnewcar")
    public ResponseEntity<Void> createCar(@Valid @ModelAttribute("CarDTO") CarDTO carDTO) {
        if (carDTO.getId() == null) {
            carService.createCar(carDTO);
        } else {
            carService.createCar(carDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

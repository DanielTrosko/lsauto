package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    private final CarService carService;

    public IndexController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("carlist", carService.getCarsList());
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
}

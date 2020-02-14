package it.danieltrosko.lsauto.restController;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {


    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}

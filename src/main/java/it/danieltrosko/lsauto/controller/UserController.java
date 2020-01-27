package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getuser")
    public UserDTO getUser(Long id){
        return userService.getUserById(id);
    }


    @PostMapping(value = "/createuser")
    public ResponseEntity<Void> createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO) {

        if (userDTO.getId() == null) {
            userService.createUser(userDTO);
        } else {
            this.userService.updateUser(userDTO);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

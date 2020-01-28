package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/getuser")
    public UserDTO getUser(Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/addnewuser")
    public String createnewUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "add_new_user";
    }


    @PostMapping(value = "/createuser")
    public String createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO) {

        if (userDTO.getId() == null) {
            userService.createUser(userDTO);
        } else {
            this.userService.updateUser(userDTO);
        }
        return "index";
    }
}

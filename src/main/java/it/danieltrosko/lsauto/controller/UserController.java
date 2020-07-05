package it.danieltrosko.lsauto.controller;

import it.danieltrosko.lsauto.dto.UserDTO;
import it.danieltrosko.lsauto.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String createUser(@RequestParam(value = "id",required = false) Long id, Model model) {
        if (id == null){
            model.addAttribute("user", new UserDTO());
            return "user/add_new_user";
        }else {
            model.addAttribute("user", userService.getUserById(id));
            return "user/add_new_user";
        }
    }

    @GetMapping(value = "/userslist")
    public String listOfUsers(@RequestParam Map<String, String> parameters,  Model model) {
        model.addAttribute("users", userService.getUsersList(parameters));
        return "user/users_list";
    }


    @PostMapping
    public String createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, Model model) {

        if (userService.checkEmailInDB(userDTO.getEmail())) {
            model.addAttribute("status", "E-mail " + userDTO.getEmail() + " posiada już inny użytkownik");
            model.addAttribute("user", userDTO);
        } else {
            model.addAttribute("status", "Użytkownik poprawnie dodany");
            model.addAttribute("user", new UserDTO());
            this.userService.createUser(userDTO);
        }
        return "user/add_new_user";
    }
}

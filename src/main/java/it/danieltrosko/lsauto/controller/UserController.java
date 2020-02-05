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


    @GetMapping(value = "/addnewuser")
    public String createnewUser(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/add_new_user";
    }

    @GetMapping(value = "/edituser")
    public String editUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user/edit_user";
    }

    @GetMapping(value = "/userslist")
    public String listOfUsers(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "user/users_list";
    }

    @PostMapping(value = "/edituser")
    public String editUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, Model model) {
        model.addAttribute("status", "Użytkownik poprawnie edytowany");
        model.addAttribute("user", userDTO);
        userService.updateUser(userDTO);
        return "user/edit_user";
    }


    @PostMapping(value = "/createuser")
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

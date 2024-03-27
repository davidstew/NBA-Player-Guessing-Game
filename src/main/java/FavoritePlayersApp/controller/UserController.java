package FavoritePlayersApp.controller;

import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserDto userDto = new UserDto();

        model.addAttribute("user", userDto);

        return "register";
    }

    @PostMapping("/register/save")
    public String createUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {

        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);

        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}

package FavoritePlayersApp.controller;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.mapper.GameMapper;
import FavoritePlayersApp.mapper.UserMapper;
import FavoritePlayersApp.service.GameService;
import FavoritePlayersApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class GameController {
    private GameService gameService;

    private UserService userService;

    @Autowired
    public GameController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @GetMapping("select-player")
    public String selectPlayer() {
        return "/select-player";
    }

    @GetMapping("game-decision")
    public String gameDecision() {
        return "/game-decision";
    }

    @GetMapping("/createGame")
    public String createGame(Model model) {
        // Logic for creating a game
        return "/create-game";
    }

//    @PostMapping("/joinGame")
//    public String joinGame() {
//        // Logic for joining a game
//        return "redirect:/game-joined";
//    }

    @PostMapping("/submitGame")
    public String submitGame(@ModelAttribute("game") GameDto gameDto, Model model) {

        User user = userService.findUserByEmail(getCurrentUser());

        gameDto.setUniqueId(generateRandomID());

        gameDto.setOwner(user);

        Game game = GameMapper.mapToGame(gameDto);

        user.getGamesOwned().add(game);

        UserDto userDto = UserMapper.mapToUserDto(user);

        UserDto userDtoSaved = userService.saveUser(userDto);

        User userSaved = UserMapper.mapToUser(userDtoSaved);

        model.addAttribute("game", game);

        model.addAttribute("user", userSaved);

        return "submitted-game-view";
    }

    public static String getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        } else {
            return "No user authenticated";
        }
    }

    public static String generateRandomID() {
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between 1000 and 9999 (inclusive)
        int randomIDInt = random.nextInt(9000) + 1000;

        // Convert the integer to a string
        String randomID = Integer.toString(randomIDInt);

        return randomID;
    }

}

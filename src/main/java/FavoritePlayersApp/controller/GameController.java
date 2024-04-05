package FavoritePlayersApp.controller;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.mapper.GameMapper;
import FavoritePlayersApp.mapper.UserMapper;
import FavoritePlayersApp.service.GameService;
import FavoritePlayersApp.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping("/select-player")
    public String selectPlayer() {
        return "/select-player";
    }

    @GetMapping("/game-decision")
    public String gameDecision() {
        return "/game-decision";
    }

    @GetMapping("/createGame")
    public String createGame(Model model) {
        return "/create-game";
    }

    @PostMapping("/submitGame")
    @Transactional
    public String submitGame(@ModelAttribute("game") GameDto gameDto, Model model) {

        User user = userService.findUserByEmail(Utilities.getCurrentUser());

        // update owning side of many-to-one relationship, default cascade.ALL behavior saves the other side
        Game submittedGame = gameService.submitGame(user, gameDto);

        // updating the other side is optional.
        //userService.saveUsersOwnedGame(user, submittedGame);

        model.addAttribute("game", submittedGame);

        model.addAttribute("user", user);

        return "submitted-game-view";
    }

    @PostMapping("/join_game")
    @Transactional
    public String joinGame(@RequestParam String gameId, Model model) {

        User user = userService.findUserByEmail(Utilities.getCurrentUser());

        Game game = gameService.findGameByUniqueId(gameId);

        // update owning side of many-to-many relationship, default cascade.ALL behavior saves the other side
        userService.joinGame(user, game);

        // optional since owning side persistence cascades to update the inverse side
        gameService.addPlayerToGame(user, game);

        model.addAttribute("game", game);

        model.addAttribute("user", user);

        List<User> playersJoinedList = new ArrayList<>(game.getPlayersJoined());

        model.addAttribute("players", playersJoinedList);

        return "join_game";
    }

}

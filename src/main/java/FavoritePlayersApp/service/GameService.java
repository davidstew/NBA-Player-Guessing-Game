package FavoritePlayersApp.service;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;

import java.util.List;

public interface GameService {
    Game submitGame(User user, GameDto gameDto);

    Game addPlayerToGame(User user, Game gameDto);

    Game findGameByUniqueId(String uniqueGameId);

    List<Game> getAllGames();

    List<Game> getAllGamesJoinedByCurrentUser(User user);
}

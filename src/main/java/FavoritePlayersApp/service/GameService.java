package FavoritePlayersApp.service;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;

public interface GameService {
    Game submitGame(GameDto gameDto);

    Game addPlayerToGame(User user, GameDto gameDto);

    Game findGameByUniqueId(String uniqueGameId);
}

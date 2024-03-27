package FavoritePlayersApp.service;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.entity.Game;

public interface GameService {
    Game submitGame(GameDto gameDto);
}

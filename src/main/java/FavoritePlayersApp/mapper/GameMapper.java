package FavoritePlayersApp.mapper;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;

import java.util.Random;

public class GameMapper {

    public static Game mapToGame(GameDto gameDto) {
        Game game = new Game();
        game.setPlayers(gameDto.getPlayers());
        game.setAttemptsAllowed(gameDto.getAttemptsAllowed());
        game.setOwner(gameDto.getOwner());
        game.setUniqueId(gameDto.getUniqueId());
        return game;
    }

    public static GameDto mapToGameDto(Game game) {

      GameDto gameDto = new GameDto();
      gameDto.setPlayers(game.getPlayers());
      gameDto.setAttemptsAllowed(game.getAttemptsAllowed());
      gameDto.setOwner(game.getOwner());
      gameDto.setUniqueId(game.getUniqueId());
      return gameDto;
    }

}

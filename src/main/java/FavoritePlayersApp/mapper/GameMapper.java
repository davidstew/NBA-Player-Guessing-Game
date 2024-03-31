package FavoritePlayersApp.mapper;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;

import java.util.Random;

public class GameMapper {

    public static Game mapToGame(GameDto gameDto) {
        Game game = new Game();
        game.setNumberOfPlayersAllowed(gameDto.getNumberOfPlayersAllowed());
        game.setAttemptsAllowed(gameDto.getAttemptsAllowed());
        game.setOwner(gameDto.getOwner());
        game.setUniqueId(gameDto.getUniqueId());
        game.setPlayersJoined(game.getPlayersJoined());
        return game;
    }

    public static GameDto mapToGameDto(Game game) {

      GameDto gameDto = new GameDto();
      gameDto.setNumberOfPlayersAllowed(game.getNumberOfPlayersAllowed());
      gameDto.setAttemptsAllowed(game.getAttemptsAllowed());
      gameDto.setOwner(game.getOwner());
      gameDto.setUniqueId(game.getUniqueId());
      gameDto.setPlayersJoined(game.getPlayersJoined());
      return gameDto;
    }

}

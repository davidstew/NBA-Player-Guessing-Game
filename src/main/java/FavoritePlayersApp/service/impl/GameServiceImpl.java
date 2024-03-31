package FavoritePlayersApp.service.impl;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.mapper.GameMapper;
import FavoritePlayersApp.repository.GameRepository;
import FavoritePlayersApp.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game submitGame(GameDto gameDto) {

        Game game = GameMapper.mapToGame(gameDto);

        return gameRepository.save(game);
    }

    @Override
    public Game addPlayerToGame(User user, GameDto gameDto) {

        Game game = GameMapper.mapToGame(gameDto);

        game.getPlayersJoined().add(user);

        return gameRepository.save(game);

    }

    @Override
    public Game findGameByUniqueId(String uniqueGameId) {

        System.out.println("LOOKNIG FOR ID: " + uniqueGameId);

        return gameRepository.findGameByUniqueId(uniqueGameId);
    }

}

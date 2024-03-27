package FavoritePlayersApp.service.impl;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.entity.Game;
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

}

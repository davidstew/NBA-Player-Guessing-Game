package FavoritePlayersApp.repository;

import FavoritePlayersApp.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}

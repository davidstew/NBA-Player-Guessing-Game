package FavoritePlayersApp.service;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;

public interface UserService {
    User findUserByEmail(String email);

    UserDto saveUsersOwnedGame(User user, Game game);

    UserDto saveUser(UserDto user);

    UserDto joinGame(User user, Game game);
}



package FavoritePlayersApp.service;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.User;

public interface UserService {
    User findUserByEmail(String email);

    UserDto saveUser(UserDto user);

    UserDto joinGame(User user, GameDto gameDto);
}



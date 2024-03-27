package FavoritePlayersApp.mapper;

import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.User;

public class UserMapper {

    public static User mapToUser(UserDto userDto) {

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setGamesOwned(userDto.getGamesOwned());

        return user;
    }

    public static UserDto mapToUserDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setGamesOwned(user.getGamesOwned());

        System.out.println(userDto);

        return userDto;
    }
}

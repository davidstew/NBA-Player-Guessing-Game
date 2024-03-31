package FavoritePlayersApp.service.impl;

import FavoritePlayersApp.dto.GameDto;
import FavoritePlayersApp.dto.UserDto;
import FavoritePlayersApp.entity.Game;
import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.mapper.GameMapper;
import FavoritePlayersApp.mapper.UserMapper;
import FavoritePlayersApp.repository.UserRepository;
import FavoritePlayersApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import utilities.Utilities;

@Service
public class UserServiceImpl implements UserService {
    
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

        User user = findUserByEmail(userDto.getEmail());

        if (user == null) {

            user = UserMapper.mapToUser(userDto);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto joinGame(User user, GameDto gameDto) {

        Game game = GameMapper.mapToGame(gameDto);

        user.getGamesJoined().add(game);

        userRepository.save(user);

        return UserMapper.mapToUserDto(user);
    }
}

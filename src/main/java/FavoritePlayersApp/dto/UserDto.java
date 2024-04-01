package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.Game;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message = "First Name should not be empty.")
    private String firstName;

    @NotEmpty(message = "Last Name should not be empty.")
    private String lastName;

    @NotEmpty(message = "Email should not be empty.")
    private String password;

    private Set<Game> gamesOwned = new HashSet<>();

    private Set<Game> gamesJoined = new HashSet<>();

    @NotEmpty(message = "Password should not be empty.")
    @Email
    private String email;
}

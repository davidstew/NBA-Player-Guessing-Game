package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    private List<Game> gamesOwned = new ArrayList<>();

    private List<Game> gamesJoined = new ArrayList<>();

    @NotEmpty(message = "Password should not be empty.")
    @Email
    private String email;
}

package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameDto {

    int numberOfPlayersAllowed;

    int attemptsAllowed;

    String uniqueId;

    private User owner;

    private List<User> playersJoined;
}

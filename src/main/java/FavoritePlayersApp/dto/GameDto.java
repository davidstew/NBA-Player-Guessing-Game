package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameDto {

    int players;

    int attemptsAllowed;

    String uniqueId;

    private User owner;
}

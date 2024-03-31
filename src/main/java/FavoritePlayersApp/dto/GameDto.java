package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameDto {

    private int numberOfPlayersAllowed;

    private int attemptsAllowed;

    private String uniqueId;

    private User owner;

    private List<User> playersJoined = new ArrayList<>();
}

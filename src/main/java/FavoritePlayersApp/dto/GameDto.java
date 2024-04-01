package FavoritePlayersApp.dto;

import FavoritePlayersApp.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private Set<User> playersJoined = new HashSet<>();
}

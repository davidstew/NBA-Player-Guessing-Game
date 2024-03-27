package FavoritePlayersApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int players;

    int attemptsAllowed;

    String uniqueId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}

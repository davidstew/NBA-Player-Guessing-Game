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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Game> gamesOwned;

    @ManyToMany
    @JoinTable(name = "joined_game",
    joinColumns = @JoinColumn("user_id"),
    inverseJoinColumns = @JoinColumn("game_id"))
    private List<Game> gamesJoined;

}

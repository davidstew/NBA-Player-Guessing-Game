package FavoritePlayersApp.security;

import FavoritePlayersApp.entity.User;
import FavoritePlayersApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        System.out.println("User is " + user.getEmail());
        System.out.println(user.getPassword());

        if (user != null) {
            System.out.println("User is not null :D ");
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(), new ArrayList<GrantedAuthority>());
        } else {
            System.out.println("Error");
            throw new UsernameNotFoundException("Invalid email or password");
        }

    }
}

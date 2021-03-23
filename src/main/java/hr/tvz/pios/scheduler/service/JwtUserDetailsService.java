package hr.tvz.pios.scheduler.service;

import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
       hr.tvz.pios.scheduler.model.User user = userService.getUserByUsername(username)
                                                            .orElseThrow(() -> new UsernameNotFoundException(""));

       return new User(
           user.getUsername(),
           user.getPassword(),
           Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }
}

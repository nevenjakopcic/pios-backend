package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.model.User;
import hr.tvz.pios.scheduler.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

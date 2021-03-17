package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.model.User;
import hr.tvz.pios.scheduler.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentUserService {

    private final UserRepository userRepository;

    public User getLoggedInUser() {
        return userRepository.findByUsername(getLoggedInUserUsername()).get();
    }

    public String getLoggedInUserUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

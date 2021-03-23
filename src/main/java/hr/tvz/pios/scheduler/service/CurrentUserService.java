package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.model.User;
import hr.tvz.pios.scheduler.model.UserRoles;
import hr.tvz.pios.scheduler.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CurrentUserService {

    private final UserRepository userRepository;

    public User getLoggedInUser() {
        return userRepository.findByUsername(getLoggedInUserUsername()).get();
    }

    private String getLoggedInUserUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    public void validateIsCurrentUserOrAdmin(Long userId) {
        User currentUser = getLoggedInUser();

        if (userId.equals(currentUser.getId()) || UserRoles.ROLE_ADMIN.equals(currentUser.getRole()))
            return;

        throw new AccessDeniedException("Access denied.");
    }
}

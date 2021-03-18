package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.ChangePasswordRequest;
import hr.tvz.pios.scheduler.dto.request.ChangeUsernameRequest;
import hr.tvz.pios.scheduler.dto.request.RegisterUserRequest;
import hr.tvz.pios.scheduler.dto.request.UserPreferencesRequest;
import hr.tvz.pios.scheduler.exception.EmailAlreadyTakenException;
import hr.tvz.pios.scheduler.exception.UsernameAlreadyTakenException;
import hr.tvz.pios.scheduler.model.User;
import hr.tvz.pios.scheduler.model.UserPreferences;
import hr.tvz.pios.scheduler.repository.PreferencesRepository;
import hr.tvz.pios.scheduler.repository.RoleRepository;
import hr.tvz.pios.scheduler.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final CurrentUserService currentUserService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PreferencesRepository preferencesRepository;
    private final PasswordEncoder passwordEncoder;

    public void save(RegisterUserRequest registerRequest) {

        UserPreferences preferences = UserPreferences.builder()
            .locale("HR")
            .darkMode(false).build();
        preferences = preferencesRepository.save(preferences);

        User user = User.builder()
            .username(registerRequest.getUsername())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .email(registerRequest.getEmail())
            .role(roleRepository.findByName("ROLE_USER"))
            .preferences(preferences)
            .disabled(false).build();

        if (getUserByUsername(registerRequest.getUsername()).isPresent()) {
            throw new UsernameAlreadyTakenException("This username is already taken.");
        }

        if (getUserByEmail(registerRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyTakenException("This email is already taken.");
        }

        userRepository.save(user);
    }

    public UserPreferences changeUserPreferences(UserPreferencesRequest request) {
        User user = currentUserService.getLoggedInUser();
        UserPreferences preferences = user.getPreferences();

        preferences.setLocale(request.getLocale());
        preferences.setDarkMode(request.getDarkMode());

        return preferencesRepository.save(preferences);
    }

    public void changeUsername(ChangeUsernameRequest request) {
        User user = currentUserService.getLoggedInUser();

        user.setUsername(request.getNewUsername());
        try {
            userRepository.save(user);
        }
        catch (DataIntegrityViolationException e) {
            throw new UsernameAlreadyTakenException("This username is already taken.", e);
        }
    }

    public void changePassword(ChangePasswordRequest request) {
        User user = currentUserService.getLoggedInUser();

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

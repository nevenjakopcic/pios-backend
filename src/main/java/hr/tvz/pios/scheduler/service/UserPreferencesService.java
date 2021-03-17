package hr.tvz.pios.scheduler.service;

import hr.tvz.pios.scheduler.dto.request.UserPreferencesRequest;
import hr.tvz.pios.scheduler.model.User;
import hr.tvz.pios.scheduler.model.UserPreferences;
import hr.tvz.pios.scheduler.repository.PreferencesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserPreferencesService {

    private final CurrentUserService currentUserService;

    private final PreferencesRepository preferencesRepository;


    public UserPreferences changeUserPreferences(UserPreferencesRequest request) {
        User user = currentUserService.getLoggedInUser();
        UserPreferences preferences = user.getPreferences();

        preferences.setLocale(request.getLocale());
        preferences.setDarkMode(request.getDarkMode());

        return preferencesRepository.save(preferences);
    }
}

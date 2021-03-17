package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.UserPreferencesRequest;
import hr.tvz.pios.scheduler.model.UserPreferences;
import hr.tvz.pios.scheduler.service.UserPreferencesService;
import hr.tvz.pios.scheduler.service.UserService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserPreferencesService preferencesService;

    @PutMapping("/preferences")
    public ResponseEntity<ApiResponse> changeUserPreferences(@Valid @RequestBody final UserPreferencesRequest request) {
        UserPreferences preferences = preferencesService.changeUserPreferences(request);

        return new ResponseEntity<>(new ApiResponse(preferences), HttpStatus.OK);
    }
}

package hr.tvz.pios.scheduler.controller;

import hr.tvz.pios.scheduler.dto.ApiResponse;
import hr.tvz.pios.scheduler.dto.request.ChangePasswordRequest;
import hr.tvz.pios.scheduler.dto.request.ChangeUsernameRequest;
import hr.tvz.pios.scheduler.dto.request.UserPreferencesRequest;
import hr.tvz.pios.scheduler.model.UserPreferences;
import hr.tvz.pios.scheduler.service.UserService;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    @PutMapping("/preferences")
    public ResponseEntity<ApiResponse> changeUserPreferences(@Valid @RequestBody final UserPreferencesRequest request) {
        UserPreferences preferences = userService.changeUserPreferences(request);

        return new ResponseEntity<>(new ApiResponse(preferences), HttpStatus.OK);
    }

    @PutMapping("/change-username")
    public ResponseEntity<ApiResponse> changeUsername(@NotBlank @RequestBody final ChangeUsernameRequest request) {
        userService.changeUsername(request);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/change-password")
    public ResponseEntity<ApiResponse> changePassword(@NotBlank @RequestBody final ChangePasswordRequest request) {
        userService.changePassword(request);
        return ResponseEntity.noContent().build();
    }
}

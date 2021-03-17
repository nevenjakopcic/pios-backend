package hr.tvz.pios.scheduler.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    @NotBlank(message = "Username is a required field.")
    private String username;

    @NotBlank(message = "Password is a required field.")
    private String password;

    @NotBlank(message = "Email is a required field.")
    private String email;
}

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
public class ChangeUsernameRequest {

    @NotBlank(message = "'newUsername' is a required field.")
    private String newUsername;
}

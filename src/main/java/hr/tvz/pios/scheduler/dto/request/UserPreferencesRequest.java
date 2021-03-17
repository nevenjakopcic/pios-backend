package hr.tvz.pios.scheduler.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPreferencesRequest {

    @NotBlank(message = "Locale is a required field.")
    private String locale;

    @NotNull(message = "Dark mode is a required field.")
    private Boolean darkMode;
}

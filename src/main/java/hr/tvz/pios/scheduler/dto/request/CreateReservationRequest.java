package hr.tvz.pios.scheduler.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {

    @FutureOrPresent
    private LocalDateTime from;

    @FutureOrPresent
    private LocalDateTime to;

    @NotBlank
    private String description;
}

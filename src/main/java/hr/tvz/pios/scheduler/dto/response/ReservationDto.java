package hr.tvz.pios.scheduler.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto implements Serializable {

    private static final long serialVersionUID = -352520537294051138L;

    private Long id;
    private LocalDateTime from;
    private LocalDateTime to;
    private String description;
    private UserDto user;
}

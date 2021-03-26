package hr.tvz.pios.scheduler.dto.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = -8200191427567232155L;

    private Long id;
    private String username;
    private String email;
    private Integer role;
}

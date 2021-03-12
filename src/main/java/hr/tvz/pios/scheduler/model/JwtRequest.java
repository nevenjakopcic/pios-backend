package hr.tvz.pios.scheduler.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 3641598005823552870L;

    private String username;
    private String password;
}

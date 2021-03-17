package hr.tvz.pios.scheduler.dto.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 3641598005823552870L;

    private String username;
    private String password;
}

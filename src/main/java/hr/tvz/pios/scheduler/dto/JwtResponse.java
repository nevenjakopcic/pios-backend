package hr.tvz.pios.scheduler.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 5611512400100614410L;

    @Getter
    private final String jwtToken;
}

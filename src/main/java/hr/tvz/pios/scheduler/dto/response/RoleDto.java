package hr.tvz.pios.scheduler.dto.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto implements Serializable {

    private static final long serialVersionUID = 8421769733052457658L;

    private Long id;
    private String name;
}

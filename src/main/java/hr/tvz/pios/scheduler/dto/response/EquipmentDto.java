package hr.tvz.pios.scheduler.dto.response;

import hr.tvz.pios.scheduler.model.EquipmentType;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto implements Serializable {

    private static final long serialVersionUID = -8620870680374966740L;

    private Long id;
    private String name;
    private EquipmentType type;
    private UserDto user;
}

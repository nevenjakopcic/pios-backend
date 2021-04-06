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
public class CreateEquipmentRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long typeId;
}

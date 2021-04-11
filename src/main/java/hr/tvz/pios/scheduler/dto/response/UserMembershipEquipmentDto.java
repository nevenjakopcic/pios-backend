package hr.tvz.pios.scheduler.dto.response;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMembershipEquipmentDto implements Serializable {

    private static final long serialVersionUID = -3683721835504306182L;

    private UserDto user;
    private List<MembershipDto> memberships;
    private List<EquipmentDto> equipments;
}

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
public class MembershipDto implements Serializable {

    private static final long serialVersionUID = 2596253970342864649L;

    private Long id;
    private LocalDateTime purchasedAt;
    private Double amount;
    private Integer purchaseType;
    private UserDto user;
    private Integer duration;
}

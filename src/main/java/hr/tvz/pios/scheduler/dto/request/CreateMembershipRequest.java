package hr.tvz.pios.scheduler.dto.request;

import hr.tvz.pios.scheduler.model.MembershipDurations;
import hr.tvz.pios.scheduler.model.PurchaseTypes;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMembershipRequest {

    @NotNull
    private LocalDateTime purchasedAt;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    private PurchaseTypes purchaseType;

    @NotNull
    private MembershipDurations duration;
}

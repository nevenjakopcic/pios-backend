package hr.tvz.pios.scheduler.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBERSHIP", schema = "pios")
@Entity(name = "MEMBERSHIP")
public class Membership implements Serializable {

    public static final long serialVersionUID = -7509791599213303317L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PURCHASED_AT", nullable = false)
    private LocalDateTime purchasedAt;

    @Column(name = "AMOUNT", precision = 18, nullable = false)
    private Double amount;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "PURCHASE_TYPE", nullable = false)
    private PurchaseTypes purchaseType;

    @OneToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "DURATION", nullable = false)
    private MembershipDurations duration;
}

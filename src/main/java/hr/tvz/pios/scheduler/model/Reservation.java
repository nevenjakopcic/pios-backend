package hr.tvz.pios.scheduler.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "RESERVATION", schema = "pios")
@Entity(name = "RESERVATION")
public class Reservation implements Serializable {

    public static final long serialVersionUID = 6867195433317932343L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FROM", nullable = false)
    private LocalDateTime from;

    @Column(name = "TO", nullable = false)
    private LocalDateTime to;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToOne
    private User user;
}

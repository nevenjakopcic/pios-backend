package hr.tvz.pios.scheduler.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EQUIPMENT", schema = "pios")
@Entity(name = "EQUIPMENT")
public class Equipment implements Serializable {

    public static final long serialVersionUID = -2296305129512209739L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToOne
    @JoinColumn(name = "EQUIPMENT_TYPE_ID")
    private EquipmentType type;

    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    @Nullable
    private User user;
}

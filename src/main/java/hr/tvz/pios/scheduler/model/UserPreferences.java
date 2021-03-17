package hr.tvz.pios.scheduler.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSON_PREFERENCES", schema = "pios")
@Entity(name = "PERSON_PREFERENCES")
public class UserPreferences implements Serializable {

    public static final long serialVersionUID = -4235164222556656477L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOCALE", nullable = false)
    private String locale;

    @Column(name = "DARKMODE", nullable = false)
    private Boolean darkMode;
}

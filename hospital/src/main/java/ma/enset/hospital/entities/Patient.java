package ma.enset.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String email;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
    private boolean malade;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
      @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    Collection<RendezVous> rendezVous ;

}

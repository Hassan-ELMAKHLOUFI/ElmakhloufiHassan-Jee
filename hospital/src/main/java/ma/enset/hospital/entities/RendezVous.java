package ma.enset.hospital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity @AllArgsConstructor @NoArgsConstructor
public class RendezVous {

    @Id
    private String id ;
    private Date date  ;
    @Enumerated(EnumType.STRING)
    private StatusRDV statusRDV ;
    @ManyToOne
    private Patient patient ;
    @ManyToOne
    private Medecin medecin ;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;

}

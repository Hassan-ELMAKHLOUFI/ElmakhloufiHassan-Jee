package ma.hassan.patientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.boot.validation.beanvalidation.*;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Size(min = 3,max = 20)
    private String nom;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateNaissance;
    private boolean malade ;
    @DecimalMin("4")
    private int score ;
}

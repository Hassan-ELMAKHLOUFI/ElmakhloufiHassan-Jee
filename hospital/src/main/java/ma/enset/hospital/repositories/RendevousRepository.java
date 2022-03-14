package ma.enset.hospital.repositories;

import ma.enset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendevousRepository extends JpaRepository<RendezVous,String> {
}

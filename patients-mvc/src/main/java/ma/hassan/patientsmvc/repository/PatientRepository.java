package ma.hassan.patientsmvc.repository;

import ma.hassan.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findPatientByNomContaining(String keyword, Pageable pageable);
}

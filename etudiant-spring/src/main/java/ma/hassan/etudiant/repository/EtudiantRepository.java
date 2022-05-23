package ma.hassan.etudiant.repository;

import ma.hassan.etudiant.entities.Etudiant;
import ma.hassan.etudiant.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Page<Etudiant> findEtudiantByNomContaining(String keyword, Pageable pageable);
}

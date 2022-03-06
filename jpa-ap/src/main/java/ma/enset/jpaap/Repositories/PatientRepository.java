package ma.enset.jpaap.Repositories;

import ma.enset.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean m);
    public List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
    public List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    public Page<Patient> findByMalade(boolean m, Pageable pageable);
    public List<Patient> findByDnBetweenAndAndMaladeIsTrueOrNomLike(Date d1, Date d2, String name);
    @Query("select p from Patient p where p.dn between :x and :y or p.nom like :z")
    public List<Patient> chercherPatient(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String name);
}

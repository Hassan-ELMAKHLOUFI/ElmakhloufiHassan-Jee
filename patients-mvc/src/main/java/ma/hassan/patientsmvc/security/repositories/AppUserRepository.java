package ma.hassan.patientsmvc.security.repositories;

import ma.hassan.patientsmvc.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {

    AppUser findAppUserByUsername(String id);


}

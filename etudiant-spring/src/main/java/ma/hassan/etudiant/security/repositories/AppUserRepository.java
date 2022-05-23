package ma.hassan.etudiant.security.repositories;

import ma.hassan.etudiant.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {

    AppUser findAppUserByUsername(String id);


}

package ma.hassan.etudiant.security.repositories;

import ma.hassan.etudiant.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findAppRoleByRoleName(String Role);
}

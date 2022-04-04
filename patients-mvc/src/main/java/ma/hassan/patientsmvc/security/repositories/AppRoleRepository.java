package ma.hassan.patientsmvc.security.repositories;

import ma.hassan.patientsmvc.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

    AppRole findAppRoleByRoleName(String Role);
}

package org.enset.jpaenset.repositories;

import org.enset.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRolename(String rolename);
}

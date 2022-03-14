package org.enset.jpaenset.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.enset.jpaenset.entities.UserC;
public interface UserRepository extends JpaRepository<UserC,String> {
    UserC findByUsername(String userName);
}

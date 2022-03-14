package org.enset.jpaenset.Service;

import lombok.AllArgsConstructor;
import org.enset.jpaenset.entities.Role;
import org.enset.jpaenset.entities.UserC;
import org.enset.jpaenset.repositories.RoleRepository;
import org.enset.jpaenset.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional

public class UserServiceImp implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
//    private PasswordEncoder passwordEncoder;
    @Override
    public UserC addNewUser(UserC user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role AddNewRole(Role role) {
        return roleRepository.save(role);
    }


    @Override
    public UserC findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String rolename) {
        return roleRepository.findByRolename(rolename);
    }

    @Override
    public void AddRoleToUserC(String userName, String roleName) {
        UserC user=findUserByUserName(userName);
        Role role= findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
           user.getRoles().add(role);
           role.getUsers().add(user);
           }
        //lorsqu'on fait transactionnel lorsqu'on modifier l'objet il s'ajout dans la base de donnees
    }

    @Override
    public UserC authenticate(String username, String pasword) {
        UserC user= userRepository.findByUsername(username);
        if(user==null) throw  new RuntimeException("bad crede");
        return user;
    }
}

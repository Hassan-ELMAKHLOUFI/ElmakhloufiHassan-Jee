package org.enset.jpaenset.Service;
import org.enset.jpaenset.entities.Role;
import org.enset.jpaenset.entities.UserC;
public interface UserService {

    UserC addNewUser(UserC user);
    Role AddNewRole(Role role);
    UserC findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    void AddRoleToUserC(String userName,String roleName);
    UserC authenticate(String username,String pasword);

}

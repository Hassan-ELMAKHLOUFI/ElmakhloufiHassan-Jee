package ma.hassan.etudiant.security.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.hassan.etudiant.security.entities.AppUser;
import ma.hassan.etudiant.security.entities.AppRole;
import ma.hassan.etudiant.security.entities.AppUser;
import ma.hassan.etudiant.security.repositories.AppRoleRepository;
import ma.hassan.etudiant.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImp implements SecurityService{

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder myPasswordEncoder;


    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if(!password.equals(rePassword)) throw new RuntimeException("Password not match");
        String hachedPWD =myPasswordEncoder.encode(password);

        AppUser appUser= new AppUser();
        appUser.setUserid(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hachedPWD);
        appUser.setActive(true);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = new AppRole();
        appRole=appRoleRepository.findAppRoleByRoleName(roleName);
        if(appRole!= null){
            throw new RuntimeException("user");
        }
       appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        appRole=appRoleRepository.save(appRole);
        return appRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findAppUserByUsername(username);
        if(appUser== null){
            throw new RuntimeException("Role already exist");
        }
        AppRole appRole = appRoleRepository.findAppRoleByRoleName(roleName);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findAppUserByUsername(username);
        if(appUser== null){
            throw new RuntimeException("Role already exist");
        }
        AppRole appRole = appRoleRepository.findAppRoleByRoleName(roleName);
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }
}

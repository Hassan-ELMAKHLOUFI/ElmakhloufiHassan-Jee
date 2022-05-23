package ma.hassan.etudiant;

import ma.hassan.etudiant.entities.Etudiant;
import ma.hassan.etudiant.entities.Genre;
import ma.hassan.etudiant.repository.EtudiantRepository;
import ma.hassan.etudiant.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class EtudiantApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtudiantApplication.class, args);
    }
    // @Bean
     CommandLineRunner commandLineRunner(EtudiantRepository etudiantRepository){
        return args -> {
            etudiantRepository.save( new Etudiant(null,"hassan","elmakhloufi","hassan@gmail.com",new Date(),true, Genre.Homme));
            etudiantRepository.save( new Etudiant(null,"ilyas","elmakhloufi","ilyas@gmail.com",new Date(),true, Genre.Homme));
            etudiantRepository.save( new Etudiant(null,"ahmed","elmakhloufi","ahmed@gmail.com",new Date(),true, Genre.Homme));

        };
    }

    @Bean
    PasswordEncoder myPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohamed","1234","1234");
            securityService.saveNewUser("yassmine","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");
            securityService.saveNewRole("user","");
            securityService.saveNewRole("admin","");
            securityService.addRoleToUser("mohamed","user");
            securityService.addRoleToUser("mohamed","admin");
            securityService.addRoleToUser("yassmine","user");
            securityService.addRoleToUser("hassan","user");

        };
    }
}

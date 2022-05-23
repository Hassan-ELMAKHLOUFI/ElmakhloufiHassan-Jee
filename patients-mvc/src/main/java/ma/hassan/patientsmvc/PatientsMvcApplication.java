package ma.hassan.patientsmvc;

import ma.hassan.patientsmvc.entities.Patient;
import ma.hassan.patientsmvc.repository.PatientRepository;
import ma.hassan.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

   // @Bean
//    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
//        return args -> {
//            patientRepository.save(new Patient(null,"hassan",new Date(),false,12));
//            patientRepository.save(new Patient(null,"Mohammed",new Date(),false,12));
//            patientRepository.save(new Patient(null,"hassan",new Date(),true,12));
//            patientRepository.save(new Patient(null,"ilyass",new Date(),false,12));
//            patientRepository.save(new Patient(null,"yassine",new Date(),false,12));
//
//        };
//    }
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

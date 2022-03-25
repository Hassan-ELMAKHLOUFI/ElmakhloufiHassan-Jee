package ma.hassan.patientsmvc;

import ma.hassan.patientsmvc.entities.Patient;
import ma.hassan.patientsmvc.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"hassan",new Date(),false,12));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),false,12));
            patientRepository.save(new Patient(null,"hassan",new Date(),true,12));
            patientRepository.save(new Patient(null,"ilyass",new Date(),false,12));
            patientRepository.save(new Patient(null,"yassine",new Date(),false,12));

        };
    }
}

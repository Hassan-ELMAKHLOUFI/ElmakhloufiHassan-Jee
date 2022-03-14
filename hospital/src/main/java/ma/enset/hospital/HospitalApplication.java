package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendevousRepository;
import ma.enset.hospital.service.Hospitalimp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(Hospitalimp hospitalimp,PatientRepository patientRepository, MedecinRepository medecinRepository, RendevousRepository rendevousRepository, ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("Mohammed","hassan","najat").forEach(name->{
                Patient  patient= new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                patientRepository.save(patient);
            });

            Stream.of("Ilyass","Hanan","Ilham").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"cardio":"Dentiste");
                medecinRepository.save(medecin);

            });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Hassan");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.PENDINGS);
            rendezVous.setPatient(patient);
            hospitalimp.saveRendevous(rendezVous);
            RendezVous rendezVous1 = rendevousRepository.findAll().get(0);
            Consultation consultation= new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRapport("Rapport de consultation");
            consultation.setRendezVous(rendezVous1);
            consultationRepository.save(consultation);
        };
    }


}

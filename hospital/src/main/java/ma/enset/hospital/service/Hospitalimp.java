package ma.enset.hospital.service;

import lombok.AllArgsConstructor;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medecin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import ma.enset.hospital.repositories.ConsultationRepository;
import ma.enset.hospital.repositories.MedecinRepository;
import ma.enset.hospital.repositories.PatientRepository;
import ma.enset.hospital.repositories.RendevousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class Hospitalimp implements IHospital{
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendevousRepository rendevousRepository;
    private ConsultationRepository consultationRepository;
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendevous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendevousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}

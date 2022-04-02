package ma.hassan.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.hassan.patientsmvc.entities.Patient;
import ma.hassan.patientsmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;

    @GetMapping(path="/user/index")
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "" ) String keyword){
        Page<Patient> pagePatients = patientRepository.findPatientByNomContaining(keyword,PageRequest.of(page,size));
        model.addAttribute("patientList",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return"patient";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path="/admin/Ajouter")
    public String Ajouter(Model model){
        model.addAttribute("patient",new Patient());
        model.addAttribute("mode","new");
        return "PatientForm";
    }
    @PostMapping("/admin/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return"PatientForm";
        patientRepository.save(patient);
        return "redirect:/PatientForm";
    }
    @GetMapping("/admin/edit")
    public String edit(Model model ,Long id){

        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        model.addAttribute("mode","edit");
        return "PatientForm";
    }


}

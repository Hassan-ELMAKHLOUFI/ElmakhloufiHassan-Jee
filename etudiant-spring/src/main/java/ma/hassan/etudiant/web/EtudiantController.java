package ma.hassan.etudiant.web;

import lombok.AllArgsConstructor;
import ma.hassan.etudiant.entities.Etudiant;
import ma.hassan.etudiant.repository.EtudiantRepository;
import ma.hassan.etudiant.entities.Etudiant;
import ma.hassan.etudiant.repository.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class EtudiantController {

    private EtudiantRepository etudiantRepository;

    @GetMapping(path="/user/index")
    public String etudiants(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="keyword",defaultValue = "" ) String keyword){
        Page<Etudiant> pageetudiants = etudiantRepository.findEtudiantByNomContaining(keyword,PageRequest.of(page,size));
        model.addAttribute("etudiantList",pageetudiants.getContent());
        model.addAttribute("pages",new int[pageetudiants.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return"etudiant";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id,String keyword,int page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @GetMapping(path="/admin/Ajouter")
    public String Ajouter(Model model){
        model.addAttribute("etudiant",new Etudiant());
        model.addAttribute("mode","new");
        return "EtudiantForm";
    }
    @PostMapping("/admin/saveEtudiant")
    public String saveEtudiant(@Valid Etudiant etudiant, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return"EtudiantForm";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index";
    }
    @GetMapping("/admin/edit")
    public String edit(Model model ,Long id){

        Etudiant etudiant = etudiantRepository.findById(id).get();
        model.addAttribute("etudiant",etudiant);
        model.addAttribute("mode","edit");
        return "EtudiantForm";
    }


}

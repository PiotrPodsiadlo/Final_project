package pl.podsiadlo.skischool1.qualification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.function.FunctionService;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/qual")
public class QualificationController {

    QualificationService qualificationService;
    FunctionService functionService;

    @Autowired
    public QualificationController(QualificationService qualificationService, FunctionService functionService) {
        this.qualificationService = qualificationService;
        this.functionService = functionService;
    }

    @GetMapping("/all")
    public String allQualifications(Model model) {
        model.addAttribute("quals",qualificationService.findAll());
        return "qualification/displayAll";
    }

    @GetMapping("/add")
    public String addQual(Model model){
        model.addAttribute("qual", new QualificationDto());
        model.addAttribute("functions", functionService.findFunctions().stream().map(e->e.getFunctionType()).collect(Collectors.toList()));
        return "qualification/create";
    }

    @PostMapping("/add")
    public String createQual(@Valid QualificationDto qualificationDto, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("qual", qualificationDto);
            model.addAttribute("functions", functionService.findFunctions().stream().map(e->e.getFunctionType()).collect(Collectors.toList()));
            return "qualification/create";
        }else{
            System.out.println(qualificationDto);
        }
        Qualification qualification = new Qualification();

        qualification.setFunction(functionService.findOne(qualificationDto.getFunction()));
        qualification.setHourlySalary(qualificationDto.getHourlySalary());
        qualification.setName(qualificationDto.getName());
        qualificationService.save(qualification);
        List all = qualificationService.findAll();
        System.out.println(all);
        return "redirect:/qual/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteQual(@PathVariable Long id) {
        qualificationService.remove(id);
        return "redirect:/qual/all";
    }

    @GetMapping("/edit/{id}")
    public String editQual(Model model, @PathVariable Long id) {
        QualificationDto qualificationDto = qualificationService.findById(id);
        model.addAttribute("qual",  qualificationDto);
        return "qualification/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateQual(@Valid QualificationDto qualificationDto, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("qual",  qualificationDto);
            System.out.println("dupa");
            return "qualification/edit";
        }
        qualificationService.updateQualFromForm(qualificationDto);
        return "redirect:/qual/all";
    }





}




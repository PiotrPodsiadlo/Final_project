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
        model.addAttribute("qual", new Qualification());
        model.addAttribute("functions", functionService.findFunctions().stream().map(e->e.getFunctionType()).collect(Collectors.toList()));
        return "qualification/create";
    }

    @PostMapping("/all")
    public String createBook(@Valid QualificationDto qualificationDto, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "qualification/create";
        }
        Qualification qualification = new Qualification();

        qualification.setFunction(functionService.findOne((long) 1));

        qualificationService.save(qualification);
        List all = qualificationService.findAll();
        System.out.println(all);
        return "qualification/displayAll";
    }







}




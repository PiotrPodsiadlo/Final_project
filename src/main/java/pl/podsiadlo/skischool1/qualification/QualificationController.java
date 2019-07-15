package pl.podsiadlo.skischool1.qualification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/qual")
public class QualificationController {

    QualificationService qualificationService;

    @Autowired
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping("/all")
    public String allQualifications(Model model) {
        model.addAttribute("quals",qualificationService.findAllQualifications());
        return "qualification/displayAll";
    }

}




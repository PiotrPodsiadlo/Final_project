package pl.podsiadlo.skischool1.lesson;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.podsiadlo.skischool1.lesson.status.LessonStatusRepository;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.qualification.QualificationDto;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/les")
public class LessonController {

    LessonRepository lessonRepository;
    LessonService lessonService;
    LessonStatusRepository lessonStatusRepository;

    public LessonController(LessonRepository lessonRepository, LessonService lessonService, LessonStatusRepository lessonStatusRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonService = lessonService;
        this.lessonStatusRepository = lessonStatusRepository;
    }

    @GetMapping("/all")
    // shows all users with attributes which are mutual for all users (name, id,  email)
    public String displayAll(Model model) {
        List<Lesson> lessons = lessonRepository.findAll();

        model.addAttribute("lessons", lessons);
        return "lesson/displayAll";
    }



    @GetMapping("/add")
    public String addLesson(Model model){
        model.addAttribute("lesson", new Lesson());

        return "lesson/create";
    }

    @PostMapping("/add")
    public String createLesson(@Valid QualificationDto qualificationDto, BindingResult result, Model model){
        if (result.hasErrors()) {
//            model.addAttribute("qual", new QualificationDto());
//            model.addAttribute("functions", functionService.findFunctions().stream().map(e->e.getFunctionType()).collect(Collectors.toList()));
            return "lesson/create";
        }

        return "redirect:/lesson/all";
    }




    @GetMapping("/edit/{id}")
    public String editLesson(Model model, @PathVariable Long id) {

        model.addAttribute("lesson");
        return "lesson/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateLesson(@Valid QualificationDto qualificationDto, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("qual",  qualificationDto);
            System.out.println("chuj");
            return "lesson/edit";
        }
//        lessonService.updateLessonFromForm(qualificationDto);
        return "redirect:/lesson/all";
    }



/*
*  Specific action to change lesson status:
*  LessonStatusRepository injection required, if status changed to paid, there is no option to mark it as canceled
* */

    @PostMapping("/setState/{id}/{state}")
    public String cancelLesson(Model model, @PathVariable Long id, @PathVariable Long stateId) {
        Lesson lesson = lessonRepository.getOne(id);
        lesson.setId(id);
        lesson.setStatus(lessonStatusRepository.getOne(stateId));
        lessonRepository.save(lesson);
        model.addAttribute("lesson");
        return "lesson/all";
    }



}

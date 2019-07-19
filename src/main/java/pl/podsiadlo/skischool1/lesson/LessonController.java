package pl.podsiadlo.skischool1.lesson;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.lesson.pricing.PricingRepository;
import pl.podsiadlo.skischool1.lesson.status.LessonStatusRepository;
import pl.podsiadlo.skischool1.qualification.QualificationDto;
import pl.podsiadlo.skischool1.user.User;
import pl.podsiadlo.skischool1.user.UserRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/les")
public class LessonController {

    private final

    LessonRepository lessonRepository;
    LessonService lessonService;
    LessonStatusRepository lessonStatusRepository;
    PricingRepository pricingRepository;
    UserRepository userRepository;

    @Autowired
    public LessonController(LessonRepository lessonRepository, LessonService lessonService, LessonStatusRepository lessonStatusRepository, PricingRepository pricingRepository, UserRepository userRepository) {
        this.lessonRepository = lessonRepository;
        this.lessonService = lessonService;
        this.lessonStatusRepository = lessonStatusRepository;
        this.pricingRepository = pricingRepository;
        this.userRepository = userRepository;
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
        List<String> instructors = userRepository.findAllByRolesName("ROLE_INSTRUCTOR").stream().map(e->e.getName()).collect(Collectors.toList());
        List<String> customers = userRepository.findAllByRolesName("ROLE_CUSTOMER").stream().map(e->e.getName()).collect(Collectors.toList());
        System.out.println(customers);
        model.addAttribute("lessonDto", new LessonDto());
        model.addAttribute("instructors", instructors);
        model.addAttribute("customers", customers);
        model.addAttribute("prices", pricingRepository.findAll().stream().map(e->e.getAmount()).collect(Collectors.toList()));
        model.addAttribute("location", Location.values());


        return "lesson/create";
    }
    @PostMapping("/add")
    public String createLesson(@Valid LessonDto lessonDto, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "lesson/create";
        }
        lessonService.createNew(lessonDto);
        return "redirect:/les/all";
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

    @GetMapping("/view/{id}")

    public String vievLesson(Model model, @PathVariable Long id) {
        LessonDto lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        return "lesson/SingleLesson";
    }

    @PostMapping("/setState/{id}/{state}")
    public String cancelLesson(Model model, @PathVariable Long id, @PathVariable Long stateId) {
        Lesson lesson = lessonRepository.getOne(id);
        lesson.setId(id);
        lesson.setStatus(lessonStatusRepository.getOne(stateId));
        lessonRepository.save(lesson);
        model.addAttribute("lesson");
        return "lesson/all";
    }




    @GetMapping("/create/{instructorId}")
    public String createLessonInSchedule(Model model, @PathVariable Long instructorId) {
        List<String> customers = userRepository.findAllByRolesName("ROLE_CUSTOMER").stream().map(e->e.getName()).collect(Collectors.toList());
        System.out.println(customers);
        User userInstructor = userRepository.getOne(instructorId);
        LessonDto lessonDto = new LessonDto();

        lessonDto.setInstructor(userInstructor.getName());
        model.addAttribute("lessonDto", lessonDto);
        model.addAttribute("instructor", userInstructor);
        model.addAttribute("customers", customers);
        model.addAttribute("prices", pricingRepository.findAll().stream().map(e->e.getAmount()).collect(Collectors.toList()));
        model.addAttribute("location", Location.values());

        return "lesson/CreateFromSchedule";
    }


}

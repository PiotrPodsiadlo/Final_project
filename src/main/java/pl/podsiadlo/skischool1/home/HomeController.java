package pl.podsiadlo.skischool1.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.podsiadlo.skischool1.lesson.Lesson;
import pl.podsiadlo.skischool1.lesson.LessonService;
import pl.podsiadlo.skischool1.user.User;
import pl.podsiadlo.skischool1.user.UserServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {


    private UserServiceImpl userServiceImpl;
    private LessonService lessonService;

    public HomeController(UserServiceImpl userServiceImpl, LessonService lessonService) {
        this.userServiceImpl = userServiceImpl;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
        log.info("info");
        log.warn("warn");
    return "home";
    }


    @RequestMapping("/oldhome")
    public String home(Model model) {
        List<User> users = userServiceImpl.findAllByRole("ROLE_INSTRUCTOR");
        List <String> units = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");
        List<Lesson> lessons = lessonService.findAll();
        model.addAttribute("units", units);
        model.addAttribute("users", users);
        model.addAttribute("lessons", lessons);
        return "homeOLD";
    }



    @RequestMapping("/home")
//    @ResponseBody
    public String homeAlt(Model model) {
        Map<User, List<Lesson>> instructorsWithTheirLessons = lessonService.convertScheduleToMap();
        model.addAttribute("map", instructorsWithTheirLessons);
        return "home";
    }



}
package pl.podsiadlo.skischool1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.podsiadlo.skischool1.user.User;
import pl.podsiadlo.skischool1.user.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    private UserServiceImpl userServiceImpl;

    public HomeController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/home")
    public String home(Model model) {
        List<User> users = userServiceImpl.findAllByRole("ROLE_INSTRUCTOR");
        List <String> hours = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");
        model.addAttribute("hours", hours);
        model.addAttribute("users", users);
        return "home";
    }







}
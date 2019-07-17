package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usrI")
public class UserControllerInstructor {

    private UserServiceImpl userServiceImpl;

    public UserControllerInstructor(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }



    @GetMapping("/details")

    public String displayAll(Model model) {
        List<User> users = userServiceImpl.findAll();

        model.addAttribute("users", users);
        return "user/displayAll";
    }




}
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

    //+++ Sample controller action to create sample user -- group for this user has to be added manually in database.+++
    @GetMapping("/sample")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setName("admin");
        user.setEmail("abc@g.pl");
        user.setPassword("admin");
        userServiceImpl.saveUser(user);
        return "admin";
    }
    //++++++++++++++++++++++++++++++++++++ above only for development purpose!++++++++++++++++++++++++++++++++++++++++++

    /*instructors can display their own details*/
    @GetMapping("/details")
    // shows all users with attributes which are mutual for all users (name, id,  email)
    public String displayAll(Model model) {
        List<User> users = userServiceImpl.findAll();

        model.addAttribute("users", users);
        return "user/displayAll";
    }




}
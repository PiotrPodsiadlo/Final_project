package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.qualification.QualificationDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usrA")
public class UserControllerAdmin {

    private UserServiceImpl userServiceImpl;

    public UserControllerAdmin(UserServiceImpl userServiceImpl) {
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




    @GetMapping("/all")
    // shows all users with ROLE_ADMIN
    public String displayAllAdmin(Model model) {
        List<User> users = new ArrayList<>();

        model.addAttribute("users", users);
        return "user/displayAllAdmins";
    }

    @GetMapping("/add")
    public String addUser(Model model){

        return "qualification/create";
    }

    @PostMapping("/add")
    public String createUser(@Valid QualificationDto qualificationDto, BindingResult result, Model model){
        if (result.hasErrors()) {

            return "qualification/create";
        }

        return "redirect:/usrA/all";
    }




}
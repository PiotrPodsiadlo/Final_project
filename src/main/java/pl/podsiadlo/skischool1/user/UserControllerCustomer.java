package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.podsiadlo.skischool1.qualification.QualificationDto;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usrC")
public class UserControllerCustomer {

    private UserServiceImpl userServiceImpl;

    public UserControllerCustomer(UserServiceImpl userServiceImpl) {
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
    // shows all CUSTOMERS
    public String displayAll(Model model) {
        List<User> users = userServiceImpl.findAll();

        model.addAttribute("users", users);
        return "user/displayAll";
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












}
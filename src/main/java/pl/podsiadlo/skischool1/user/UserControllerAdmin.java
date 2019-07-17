package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.qualification.QualificationDto;
import pl.podsiadlo.skischool1.role.Role;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usrA")
public class UserControllerAdmin  {

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

    @GetMapping("/r/{name}")
    @ResponseBody
    public String rolesOfUser(@PathVariable String name){
        User user = userServiceImpl.findByUserName(name);
        List<User> rolesOfUser = userServiceImpl.findUsrRoles(user);
        return rolesOfUser.stream().map(e-> e.getName()).collect(Collectors.joining(", "));
    }


    @GetMapping("/allA")
    // shows all users with ROLE_ADMIN
    public String displayAllAdmin(Model model) {
        List<User> users = new ArrayList<>();

        model.addAttribute("users", users);
        return "user/displayAllAdmins";
    }
/** admin can add users of any role except ROLE_ADMIN */

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

    /** admin can edit users of any role except ROLE_ADMIN */

    @GetMapping("/edit/{id}/{role}")
    public String editLesson(Model model, @PathVariable Long id, @PathVariable Long role) {

        model.addAttribute("lesson");
        return "lesson/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateLesson(@Valid QualificationDto qualificationDto, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {

            return "lesson/edit";
        }

        return "redirect:/lesson/all";
    }



    /* only admin can activate employees created by reception workers */
    @GetMapping("/activate/{id}")
    public String activateEmployee(){
        return "a";
    }
}
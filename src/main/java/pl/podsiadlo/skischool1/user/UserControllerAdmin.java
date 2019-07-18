package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.podsiadlo.skischool1.enums.UserState;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.qualification.QualificationDto;
import pl.podsiadlo.skischool1.qualification.QualificationService;
import pl.podsiadlo.skischool1.role.Role;
import pl.podsiadlo.skischool1.role.RoleRepository;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usrA")
public class UserControllerAdmin  {

    private UserServiceImpl userServiceImpl;
    private RoleRepository roleRepository;
    private QualificationService qualificationService;


    public UserControllerAdmin(UserServiceImpl userServiceImpl, RoleRepository roleRepository, QualificationService qualificationService) {
        this.userServiceImpl = userServiceImpl;
        this.roleRepository = roleRepository;
        this.qualificationService = qualificationService;
    }

    @GetMapping("/r/{name}")
    @ResponseBody
    public String rolesOfUser(@PathVariable String name){

        List<User> usersWithRole = userServiceImpl.findAllByRole(name);
        return usersWithRole.stream().map(e-> e.getName()).collect(Collectors.joining(", "));
    }


    @GetMapping("/all")
    public String displayAllAdmin(Model model) {
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "user/displayAll";
    }
/** admin can add users of any role except ROLE_ADMIN */

//    @ModelAttribute("skills")
//    public Set<Role> roles()

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("roles", roleRepository.findAll().stream().map(e-> e.getName()).collect(Collectors.toList()));
        model.addAttribute("qualifications", qualificationService.findAllObj().stream().map(e-> e.getName()).collect(Collectors.toList()));
        model.addAttribute("status", UserState.values());
        return "user/create";
    }

    @PostMapping("/add")
    public String createUser(@Valid UserDto userDto, BindingResult result, Model model){
        if (result.hasErrors()) {

            return "user/create";
        }

        userServiceImpl.saveByAdmin(userDto);
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
    public String activateEmployee(@PathVariable Long id, Model model){
        userServiceImpl.activate(id);
        return "a";
    }
}
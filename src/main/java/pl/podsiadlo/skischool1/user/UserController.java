package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.podsiadlo.skischool1.role.Role;
import pl.podsiadlo.skischool1.role.RoleRepository;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usr")
public class UserController {

    private UserServiceImpl userServiceImpl;
    private RoleRepository roleRepository;

    public UserController(UserServiceImpl userServiceImpl, RoleRepository roleRepository) {
        this.userServiceImpl = userServiceImpl;
        this.roleRepository = roleRepository;
    }

    //+++ Sample controller action to create sample user -- group for this user has to be added manually in database.+++
    @GetMapping("/sample")
    @ResponseBody
    public String createSampleUser() {
        Role role = roleRepository.findByName("ROLE_INSTRUCTOR");
        System.out.println(role.getName());
        Set<Role> newUserRoles = new HashSet<>();
        newUserRoles.add(role);
        System.out.println(newUserRoles.size());
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("instructor: "+i);
            user.setEmail("abc@g.pl");
            user.setPassword("admin");
            userServiceImpl.saveUser(user);
            System.out.println(user.getRoles());
        }
        return "admin";
    }
    // method will remove instructors with only one role: ROLE_INSTRUCTOR
    @GetMapping("/sample/del")
    @ResponseBody
    public void deleteOnlyInnstructors(){
        System.out.println(userServiceImpl.findAllByRole("ROLE_INSTRUCTOR"));
        List<User> users = userServiceImpl.findAllByRole("ROLE_INSTRUCTOR");
        List<User> collect = users.stream().filter(e -> e.getRoles().size() == 1).collect(Collectors.toList());
        collect.stream().forEach(e -> userServiceImpl.safeDelete(e));


    }
    //++++++++++++++++++++++++++++++++++++ above only for development purpose!++++++++++++++++++++++++++++++++++++++++++


    @GetMapping("/all")
    // shows all users with attributes which are mutual for all users (name, id,  email)
    public String displayAll(Model model) {
        List<User> users = userServiceImpl.findAll();

        model.addAttribute("users", users);
        return "user/displayAll";
    }


}
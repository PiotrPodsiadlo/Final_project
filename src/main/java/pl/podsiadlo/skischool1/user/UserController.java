package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/usr")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
// Sample controller action to create sample user -- group for this user has to be added manually in database.
    @GetMapping("/sample")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setName("admin");
        user.setEmail("abc@g.pl");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }





}
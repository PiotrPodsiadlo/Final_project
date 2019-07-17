package pl.podsiadlo.skischool1.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.podsiadlo.skischool1.enums.UserState;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.qualification.QualificationService;
import pl.podsiadlo.skischool1.role.Role;
import pl.podsiadlo.skischool1.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl  {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final QualificationService qualificationService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder, QualificationService qualificationService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.qualificationService = qualificationService;
    }

    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }

/*SERVICE ONLY FOR DEVELOPEMENT PURPOSE !!!!!!!!!*/
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_INSTRUCTOR");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
/*SERVICE ONLY FOR DEVELOPEMENT PURPOSE !!!!!!!!!*/


    public List<User> findAll(){
        return userRepository.findAll();
    }



    public List<User> findAllByRole(String role){
        return userRepository.findAllByRolesName(role);
    }
    //method to delete users with relations (e.g. with roles)
    public void safeDelete(User user){
        user.setRoles(null);
        user.setQualifications(null);
        userRepository.delete(user);
    }

    public void saveByAdmin(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setSalary(userDto.getSalary());
        user.setStatus(UserState.valueOf(userDto.getStatus()));
        Set<Role> newUserRoles = new HashSet<>();
        userDto.getRoles().stream().map(e-> roleRepository.findByName(e)).forEach(e -> newUserRoles.add(e));
        user.setRoles(newUserRoles);
        Set <Qualification> newUserQualifications = new HashSet<>();
        userDto.getQualifications().stream().map(e-> qualificationService.findByName(e)).forEach(e-> newUserQualifications.add(e) );
        user.setEnabled(userDto.getEnabled());
        userRepository.save(user);
    }
}


package pl.podsiadlo.skischool1.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.podsiadlo.skischool1.role.Role;
import pl.podsiadlo.skischool1.role.RoleRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@Service
public class UserServiceImpl  {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findByUserName(String username) {
        return userRepository.findByName(username);
    }


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_INSTRUCTOR");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

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
}


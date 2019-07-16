package pl.podsiadlo.skischool1.securityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.podsiadlo.skischool1.user.User;
//import pl.podsiadlo.skischool1.user.UserService;
import pl.podsiadlo.skischool1.user.UserServiceImpl;

import java.util.HashSet;
import java.util.Set;
// service for authentication
public class SpringDataUserDetailsService implements UserDetailsService {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public void setUserRepository(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userServiceImpl.findByUserName(username);
        if (user == null) {throw new UsernameNotFoundException(username); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new org.springframework.security.core.userdetails.User(
                user.getName(), user.getPassword(), grantedAuthorities);
    }
}
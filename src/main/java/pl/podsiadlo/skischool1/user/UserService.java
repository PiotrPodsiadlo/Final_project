package pl.podsiadlo.skischool1.user;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

        User findByUserName(String name);

        void saveUser(User user);
}


package pl.podsiadlo.skischool1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.role.Role;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String username);



// method to find all users by specific role
    List<User> findAllByRolesName(String name);          //i jak tu teraz wyciagnac cos z bazy jak nie ma odpowiedniej


}

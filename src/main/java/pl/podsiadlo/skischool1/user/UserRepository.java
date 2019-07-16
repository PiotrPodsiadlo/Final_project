package pl.podsiadlo.skischool1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.qualification.Qualification;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String username);

//   select * from user join user_roles on user.id = user_roles.user_id where roles_id = 5;  // query to find all users with ROLE_ADMIN role

//   select * from user join user_roles on user.id = user_roles.user_id where roles_id = 2; // query to find all instructors

//   select * from user join user_roles on user.id = user_roles.user_id where roles_id = 3; // query to find all customers

//    @Query ("select u from User u join ")
//    List<User> findAllByAdminRole();          i jak tu teraz wyciagnac cos z bazy jak nie ma odpowiedniej


}

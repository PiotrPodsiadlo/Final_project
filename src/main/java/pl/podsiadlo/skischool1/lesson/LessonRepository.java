package pl.podsiadlo.skischool1.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.qualification.Qualification;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    //Lesson findByName(String username);
}

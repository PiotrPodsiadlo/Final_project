package pl.podsiadlo.skischool1.lesson.status;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonStatusRepository extends JpaRepository<LessonStatus, Long> {
}

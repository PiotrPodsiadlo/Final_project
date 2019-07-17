package pl.podsiadlo.skischool1.lesson.status;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.lesson.pricing.Pricing;

@Repository
public interface LessonStatusRepository extends JpaRepository<LessonStatus, Long> {
    Pricing findFirstByName(String name);
}

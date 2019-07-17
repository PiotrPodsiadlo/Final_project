package pl.podsiadlo.skischool1.lesson.pricing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.lesson.Lesson;

import java.math.BigDecimal;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Long>{
    Pricing findFirstByAmount(BigDecimal amount);
}


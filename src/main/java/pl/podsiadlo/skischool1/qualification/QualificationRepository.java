package pl.podsiadlo.skischool1.qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {

    Qualification findFirstByName(String name);
}

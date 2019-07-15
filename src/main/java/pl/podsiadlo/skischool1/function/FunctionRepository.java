package pl.podsiadlo.skischool1.function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.podsiadlo.skischool1.qualification.Qualification;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {

    Function findFirstByType(String type);

}

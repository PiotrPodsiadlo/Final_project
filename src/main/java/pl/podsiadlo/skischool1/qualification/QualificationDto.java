package pl.podsiadlo.skischool1.qualification;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

public class QualificationDto {

    private Long id;
    String name;
    String function;
    double hourlySalary;

    public QualificationDto(Qualification that) {
        this.name = that.getName();
        this.function = that.getFunction().getFunctionType();
        this.hourlySalary = that.getHourlySalary();

    }
}

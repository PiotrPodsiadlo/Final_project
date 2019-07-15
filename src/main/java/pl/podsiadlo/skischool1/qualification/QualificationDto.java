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

    public Long getId() {
        return id;
    }

    public QualificationDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public QualificationDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getFunction() {
        return function;
    }

    public QualificationDto setFunction(String function) {
        this.function = function;
        return this;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public QualificationDto setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        return this;
    }
}

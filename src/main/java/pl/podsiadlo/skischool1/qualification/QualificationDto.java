package pl.podsiadlo.skischool1.qualification;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class QualificationDto {

    private Long id;
    @Size(min=1, max=100)
    private String name;
    private String function;
    private Long functionId;
    private double hourlySalary;

    public QualificationDto() {
    }

    public QualificationDto(Qualification that) {
        this.id = that.getId();
        this.name = that.getName();
        this.function = that.getFunction().getFunctionType();
        this.hourlySalary = that.getHourlySalary();
        this.functionId = that.getId();
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

    public Long getFunctionId() {
        return functionId;
    }

    public QualificationDto setFunctionId(Long functionId) {
        this.functionId = functionId;
        return this;
    }
}

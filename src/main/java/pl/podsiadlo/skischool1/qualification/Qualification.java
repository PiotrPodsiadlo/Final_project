package pl.podsiadlo.skischool1.qualification;

import pl.podsiadlo.skischool1.function.Function;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
//@Table(name = "qualification")
public class Qualification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    @ManyToOne
    Function function;
    double hourlySalary;


    public Qualification() {
    }

    public Long getId() {
        return id;
    }

    public Qualification setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Qualification setName(String name) {
        this.name = name;
        return this;
    }

    public Function getFunction() {
        return function;
    }

    public Qualification setFunction(Function function) {
        this.function = function;
        return this;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public Qualification setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
        return this;
    }
}
/**
 * Qualification describes level of abilities of instructor. Specific categories are
 * linked with specific salary. Qualifications can be added by admin .If not explicitely provided, Instructor's  basic hourly salary depends on his/her qualification
 * relation: Qualification -> Salary = OneToOne
 * relation: Qualification <- Function OnetoMany
 * Only instructors who are both snowboard and ski instructors can have two Qualifications, the rest can have only one .
 *
 *
 *
* */
package pl.podsiadlo.skischool1.function;

import pl.podsiadlo.skischool1.qualification.Qualification;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "functions")
public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToMany(mappedBy = "function")
    private Set<Qualification> qualifications =
            new HashSet<>();

    public Function() {
    }


    public Long getId() {
        return id;
    }

    public Function setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFunctionType() {
        return type;
    }

    public Function setFunctionType(String type) {
        this.type = type;
        return this;
    }
}


/**
 *
 *  Function should define if Instructor is a ski or snowboard instructor (or both). Functions MIGHT NOT be defined by user
 *  relation: Instructor -> Function = ManyToMany
 *  relation: Function -> Qualification = OneToMany
 *
 */
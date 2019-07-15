package pl.podsiadlo.skischool1.function;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;


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
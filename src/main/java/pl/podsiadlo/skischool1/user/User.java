package pl.podsiadlo.skischool1.user;

import lombok.Data;
import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.lesson.Lesson;
import pl.podsiadlo.skischool1.qualification.Qualification;

import javax.persistence.*;
import java.util.*;

@Data       // default getter and setter from lombok
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToMany
    @JoinTable(name = "users_qualifications",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private Set<Qualification> qualifications = new HashSet<>();
    @Column(nullable = true, unique = false)
    private double salary;

//    private Role role;
    private int status;                                                         // 0=not active (cannot be added to schedule) 1=active, can be added to schedule, 2=active, scheduled
    private int enabled = 0;


}



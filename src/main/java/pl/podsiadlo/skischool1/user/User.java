package pl.podsiadlo.skischool1.user;

import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.qualification.Qualification;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @ManyToMany
    private Set<Qualification> qualifications = new HashSet<>();
    private String role;
    private double salary;
    private int lessonCount;
    private int status;                                                         // 0=not active (cannot be added to schedule) 1=active, can be added to schedule, 2=active, scheduled



}



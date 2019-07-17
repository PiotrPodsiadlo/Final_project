package pl.podsiadlo.skischool1.user;

import lombok.Data;
import pl.podsiadlo.skischool1.enums.UserState;
import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.lesson.Lesson;
import pl.podsiadlo.skischool1.qualification.Qualification;
import pl.podsiadlo.skischool1.role.Role;

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
    @Column(nullable = true, unique = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "users_qualifications",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id"))
    private Set<Qualification> qualifications = new HashSet<>();
    @Column(nullable = true, unique = false)
    private double salary;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Enumerated(EnumType.STRING)
    @Column(nullable = true, unique = false)
    private UserState status;                                                         // 0=not active (cannot be added to schedule) 1=active, can be added to schedule, 2=active, scheduled
    private int enabled;


    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}



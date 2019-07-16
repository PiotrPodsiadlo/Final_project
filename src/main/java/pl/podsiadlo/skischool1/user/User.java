package pl.podsiadlo.skischool1.user;

import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.qualification.Qualification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@Entity
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastname;
    private String email;
    private String mobileNumber;
    private String sex;

    private Set<Qualification> qualifications = new HashSet<>();
    private String role;
    private Date whenCreated;
    private double salary;
    private int lessonCount;
    private boolean isActive;
    private boolean isScheduled;
    

}



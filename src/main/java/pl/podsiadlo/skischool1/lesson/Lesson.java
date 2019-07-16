package pl.podsiadlo.skischool1.lesson;


import pl.podsiadlo.skischool1.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//@Entity
public class Lesson {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date scheduled;                                         // time of the lesson
    private User instructor;                                        // who teaches on this lesson
    private User customer;                                          // who is the student
    private int durationMins;
    private int durationHours;
    private double price;
    private double instructorCost;
    private String location;

}

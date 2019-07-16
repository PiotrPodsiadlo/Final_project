package pl.podsiadlo.skischool1.lesson;

import pl.podsiadlo.skischool1.location.Location;
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
    private Date created;
    private Date scheduled;
    private User instructor;
    private User customer;
    private double durationMins;
    private double price;
    private double instructorCosty;
    private Location location;

}

package pl.podsiadlo.skischool1.lesson;


import lombok.Data;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.lesson.pricing.Pricing;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.user.User;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date scheduled;                                         // time of the lesson
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;                                        // who teaches on this lesson
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;                                          // who is the student
    @ManyToOne
    @JoinColumn(name = "receptionist_id")
    private User receptionist;                                      // who scheduled this lesson
    private int durationMins;                                       // how many minutes/hours takes that lesson
    private int durationHours;
    @ManyToOne
    private Pricing price;                                          // price from the pricing list
    private double instructorCost;
    private Date timeOfLesson;                                      //exact DateTime when lesson starts
    @Column(nullable = true, unique = false)
    private int numberOfParticipants;                               //number of participants means that one customer can book lesson for many participants, one who booked a lesson is a customer and can be added as an user in database
    @ManyToOne
    private LessonStatus status;                                    // lesson can be booked, paid, cancelled(after/before payment), refounded etc.
    @Enumerated(EnumType.STRING)                                    // we use enumerated type for location
    private Location location;
}

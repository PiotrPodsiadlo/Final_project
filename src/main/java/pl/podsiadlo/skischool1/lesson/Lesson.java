package pl.podsiadlo.skischool1.lesson;


import pl.podsiadlo.skischool1.lesson.pricing.Pricing;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.user.User;

import javax.persistence.*;
import java.util.Date;

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
    private int durationMins;
    private int durationHours;
    @ManyToOne
    private Pricing price;
    private double instructorCost;
    private Date timeOfLesson;
    @Column(nullable = true, unique = false)
    private String location;
    private int numberOfParticipants;
    @ManyToOne
    private LessonStatus status;
}

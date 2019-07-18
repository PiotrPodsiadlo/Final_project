package pl.podsiadlo.skischool1.lesson;


import lombok.Data;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.lesson.pricing.Pricing;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private double durationHours;
    @ManyToOne
    private Pricing price;                                          // price from the pricing list
    private double instructorCost;
    private LocalDate dayOfLesson;
    private LocalTime timeOfLesson;
    @Column(nullable = true, unique = false)
    private int numberOfParticipants;                               //number of participants means that one customer can book lesson for many participants, one who booked a lesson is a customer and can be added as an user in database
    @ManyToOne
    private LessonStatus status;                                    // lesson can be booked, paid, cancelled(after/before payment), refounded etc.
    @Enumerated(EnumType.STRING)                                    // we use enumerated type for location
    private Location location;
    private double discount;
    private String additionalInfo;
//  calculated
    private double totalPrice;

    public Lesson setTotalPrice(double durationHours, Pricing price, double discount) {
        this.totalPrice = (durationHours* price.getAmount() - discount);
        return this;
    }
}

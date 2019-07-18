package pl.podsiadlo.skischool1.lesson;


import lombok.Data;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.lesson.pricing.Pricing;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime scheduled;                                         // time of the lesson
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
    @ManyToOne
    private LessonStatus status;                                    // lesson can be booked, paid, cancelled(after/before payment), refounded etc.
    @Enumerated(EnumType.STRING)                                    // we use enumerated type for location
    private Location location;
    private double discount;
    private String additionalInfo;
//  calculated
    private double totalPrice;



    public Lesson setTotalPrice(double durationHours, Pricing price, double discount) {
        this.totalPrice = (durationHours * price.getAmount() - discount);
        return this;
    }
}

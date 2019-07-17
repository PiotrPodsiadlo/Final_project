package pl.podsiadlo.skischool1.lesson;

import lombok.Data;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.lesson.pricing.Pricing;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class LessonDto {

    private Long id;
    private String instructor;
    private String customer;
    private int durationHours;
    private BigDecimal price;
    private Date dayAndHourOfLesson;
    private int numberOfParticipants;
    private String status;
    private String location;
    private BigDecimal discount;

}

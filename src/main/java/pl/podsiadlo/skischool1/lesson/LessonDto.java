package pl.podsiadlo.skischool1.lesson;

import lombok.Data;


import javax.persistence.*;

@Data
public class LessonDto {

    private Long id;
    private String instructor;
    private String customer;
    private double durationHours;
    private double price;
    private String dayOfLesson;
    private String timeOfLesson;
    private int numberOfParticipants;
    private String status;
    private String location;
    private double discount;
    private String additionalInfo;


    //used only for view
    private String scheduled;


}

package pl.podsiadlo.skischool1.lesson;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.podsiadlo.skischool1.lesson.pricing.PricingRepository;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.lesson.status.LessonStatusRepository;
import pl.podsiadlo.skischool1.user.User;
import pl.podsiadlo.skischool1.user.UserRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class LessonService {

    LessonStatusRepository lessonStatusRepository;
    LessonRepository lessonRepository;
    UserRepository userRepository;
    PricingRepository pricingRepository;



    public LessonService(LessonStatusRepository lessonStatusRepository, LessonRepository lessonRepository, UserRepository userRepository, PricingRepository pricingRepository) {
        this.lessonStatusRepository = lessonStatusRepository;
        this.lessonRepository = lessonRepository;
        this.userRepository = userRepository;
        this.pricingRepository = pricingRepository;
    }


    public void createNew(LessonDto lessonDto){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");            // parsing date cos Dto accepts String

        Lesson lesson = new Lesson();
        lesson.setDayOfLesson(LocalDate.parse(lessonDto.getDayOfLesson(), dateFormatter));
        lesson.setTimeOfLesson(LocalTime.parse(lessonDto.getTimeOfLesson()));
        lesson.setAdditionalInfo(lessonDto.getAdditionalInfo());
        lesson.setDurationHours(lessonDto.getDurationHours());
        lesson.setPrice(pricingRepository.findFirstByAmount(lessonDto.getPrice()));
        lesson.setDiscount(lessonDto.getDiscount());
        lesson.setInstructor(userRepository.findByName(lessonDto.getInstructor()));
        lesson.setCustomer(userRepository.findByName(lessonDto.getCustomer()));

        lesson.setTotalPrice(lesson.getDurationHours(), lesson.getPrice(), lesson.getDiscount());
        lesson.setStatus(lessonStatusRepository.findFirstByName("booked"));
        lessonRepository.save(lesson);
//        User instructor = userRepository.findByName(lessonDto.getInstructor());
//        User customer = userRepository.findByName(lessonDto.getCustomer());


    }
}

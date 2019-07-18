package pl.podsiadlo.skischool1.lesson;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.podsiadlo.skischool1.enums.Location;
import pl.podsiadlo.skischool1.enums.UserState;
import pl.podsiadlo.skischool1.lesson.pricing.PricingRepository;
import pl.podsiadlo.skischool1.lesson.status.LessonStatus;
import pl.podsiadlo.skischool1.lesson.status.LessonStatusRepository;
import pl.podsiadlo.skischool1.user.User;
import pl.podsiadlo.skischool1.user.UserRepository;
import pl.podsiadlo.skischool1.user.UserServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

@Service
@Transactional
public class LessonService {



    LessonStatusRepository lessonStatusRepository;
    LessonRepository lessonRepository;
    UserRepository userRepository;
    PricingRepository pricingRepository;
    UserServiceImpl userServiceImpl;



    public LessonService(LessonStatusRepository lessonStatusRepository, LessonRepository lessonRepository, UserRepository userRepository, PricingRepository pricingRepository, UserServiceImpl userServiceImpl) {
        this.lessonStatusRepository = lessonStatusRepository;
        this.lessonRepository = lessonRepository;
        this.userRepository = userRepository;
        this.pricingRepository = pricingRepository;
        this.userServiceImpl = userServiceImpl;
    }


    public void createNew(LessonDto lessonDto){
        LocalDateTime scheduleDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");            // parsing date cos Dto accepts String
        Lesson lesson = new Lesson();
        lesson.setScheduled(scheduleDate);

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
        lesson.setLocation(Location.valueOf(lessonDto.getLocation()));
        lessonRepository.save(lesson);
    }



    public LessonDto findById(Long id){
        Lesson lesson = lessonRepository.getOne(id);
        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setDurationHours(lesson.getDurationHours());
        lessonDto.setAdditionalInfo(lesson.getAdditionalInfo());
        lessonDto.setCustomer(lesson.getCustomer().getName());
        lessonDto.setInstructor(lesson.getInstructor().getName());
        lessonDto.setDayOfLesson(lesson.getDayOfLesson().toString());
        lessonDto.setTimeOfLesson(lesson.getTimeOfLesson().toString());
        lessonDto.setScheduled(lesson.getScheduled().getDayOfWeek() + " " +lesson.getScheduled().getHour()+ " : " + lesson.getScheduled().getMinute());
        lessonDto.setStatus(lesson.getStatus().getName());
        lessonDto.setDiscount(lesson.getDiscount());
        lessonDto.setLocation(lesson.getLocation().toString());
        lessonDto.setTotalPrice(lesson.getTotalPrice());
        System.out.println(lesson.getLocation());

        return lessonDto;
    }

    public List<Lesson> findAll(){
        return lessonRepository.findAll();
    }


    public Map<User, List<Lesson>> convertScheduleToMap() {
        List<User> allInstructor = userServiceImpl.findAllByRole("ROLE_INSTRUCTOR");
        List<Lesson> allLesson = lessonRepository.findAll();
        Map<User, List<Lesson>> instructorsWithTheirLessons = new HashMap<>();

        for (User instructor : allInstructor) {
            List<Lesson> allLessonsOfThisInstructor = allLesson.stream()
                    .filter(e -> e.getInstructor().getId().equals( instructor.getId()))
                    .collect(Collectors.toList());
            instructorsWithTheirLessons.put(instructor, allLessonsOfThisInstructor);
        }


//        Map<User, List<Lesson>> collect = allLesson.stream().collect(Collectors.groupingBy(Lesson::getInstructor));
//
//        System.out.println(collect);
//        return collect;

        return instructorsWithTheirLessons;
    }





}

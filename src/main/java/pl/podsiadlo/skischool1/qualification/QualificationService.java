package pl.podsiadlo.skischool1.qualification;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.podsiadlo.skischool1.function.Function;
import pl.podsiadlo.skischool1.function.FunctionRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class QualificationService {

    QualificationRepository qualificationRepository;
    FunctionRepository functionRepository;

    public QualificationService(QualificationRepository qualificationRepository, FunctionRepository functionRepository) {
        this.qualificationRepository = qualificationRepository;
        this.functionRepository = functionRepository;
    }

    public List<QualificationDto> findAll(){
        return qualificationRepository.findAll().stream().map(e -> new QualificationDto(e)).collect(Collectors.toList());
    }

    public void createQualification(QualificationDto qualificationDto){
        Qualification qualification = new Qualification();
        qualification.setName(qualificationDto.getName());
        qualificationRepository.save(qualification);

    }
    public void save(Qualification qualification){
        qualificationRepository.save(qualification);
    }




}

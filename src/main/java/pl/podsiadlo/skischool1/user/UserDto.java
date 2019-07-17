package pl.podsiadlo.skischool1.user;

import lombok.Data;
import pl.podsiadlo.skischool1.enums.UserState;
import pl.podsiadlo.skischool1.qualification.Qualification;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
public class UserDto {


    private String name;
    private String email;

    private String password;

    private Set<String> qualifications = new HashSet<>();

    private double salary;

    private Set<String> roles;
    private String status;
    private int enabled;
}

package pl.podsiadlo.skischool1.function;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Function {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String functionType;
}


/**
 *
 * Function definiuje, czy instrutkor jest snowboardzista, czy narciarzem, czy oboma.
 *  relacje Instructor -> Function = ManyToMany
 *  relacje Function -> Qualification = OneToMany
 *
 *
 *
 */
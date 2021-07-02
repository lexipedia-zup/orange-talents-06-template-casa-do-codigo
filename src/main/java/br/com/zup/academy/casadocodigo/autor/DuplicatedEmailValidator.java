package br.com.zup.academy.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class DuplicatedEmailValidator implements ConstraintValidator<DuplicatedEmail, String> {

    private boolean unique;

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public void initialize(DuplicatedEmail constraintAnnotation) {
        unique = constraintAnnotation.unique();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        System.out.println("Entrando no método isValid");

        Optional<Autor> autor = autorRepository.findByEmail(value);


        if(autor.isPresent() && unique){
            return false;
        }

        return true;
    }
}
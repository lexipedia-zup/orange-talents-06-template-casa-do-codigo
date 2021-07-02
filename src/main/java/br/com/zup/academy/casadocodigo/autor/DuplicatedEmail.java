package br.com.zup.academy.casadocodigo.autor;

import org.springframework.data.domain.Page;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = DuplicatedEmailValidator.class)
public @interface DuplicatedEmail {

    public boolean unique() default false;

    String message() default "O email já está cadastrado";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
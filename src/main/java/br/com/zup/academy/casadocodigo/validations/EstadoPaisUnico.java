package br.com.zup.academy.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy =  EstadoPaisUnicoValidator.class)
public @interface EstadoPaisUnico {
    String message() default "País já cadastrado para esse estado";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}

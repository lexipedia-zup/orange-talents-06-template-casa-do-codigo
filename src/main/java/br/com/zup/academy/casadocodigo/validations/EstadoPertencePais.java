package br.com.zup.academy.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy =  EstadoPertencePaisValidator.class)
public @interface EstadoPertencePais {

    String message() default "Estado não pertence à esse país";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}

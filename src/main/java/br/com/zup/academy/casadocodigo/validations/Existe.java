package br.com.zup.academy.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy =  ExisteValidator.class)
public @interface Existe {

    String message() default "Valor não encontrado";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

    String fieldName();

    Class<?> domainClass();

}

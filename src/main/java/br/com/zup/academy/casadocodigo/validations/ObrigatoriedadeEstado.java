package br.com.zup.academy.casadocodigo.validations;

import br.com.zup.academy.casadocodigo.validations.EstadoPertencePaisValidator;
import br.com.zup.academy.casadocodigo.validations.ObrigatoriedadeEstadoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy =  ObrigatoriedadeEstadoValidator.class)
public @interface ObrigatoriedadeEstado {

    String message() default "Um estado deve ser selecionado";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

}

package br.com.zup.academy.casadocodigo.validations;

import br.com.zup.academy.casadocodigo.autor.AutorRepository;
import br.com.zup.academy.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class DuplicatedValueValidator implements ConstraintValidator<Unique, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> classe;

    private String atributo;

    @Override
    public void initialize(Unique constraintAnnotation) {
        atributo = constraintAnnotation.fieldName();
        classe = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Query query = entityManager.createQuery("select 1 from " + classe.getName()+" where "+atributo+"=:value");
        query.setParameter("value", value);
        List<?> lista = query.getResultList();
        Assert.state(lista.size() <= 1, "O "+atributo+" digitado já foi cadastrado no sistema.");

        return lista.isEmpty();
    }
}

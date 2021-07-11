package br.com.zup.academy.casadocodigo.validations;

import br.com.zup.academy.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteValidator implements ConstraintValidator<Existe, Integer> {

    private String atributo;
    private Class<?> classe;
    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(Existe constraintAnnotation) {
        this.atributo = constraintAnnotation.fieldName();
        this.classe = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        Query query = em.createQuery("select 1 from "+ classe.getName() + " where "+ atributo +"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        return !list.isEmpty();
    }
}

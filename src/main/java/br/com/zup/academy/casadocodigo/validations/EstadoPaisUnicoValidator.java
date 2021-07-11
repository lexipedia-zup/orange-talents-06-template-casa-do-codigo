package br.com.zup.academy.casadocodigo.validations;

import br.com.zup.academy.casadocodigo.estado.EstadoRequestDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstadoPaisUnicoValidator implements ConstraintValidator<EstadoPaisUnico, EstadoRequestDto> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean isValid(EstadoRequestDto dto, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT 1 FROM Estado e WHERE e.nome =:nome AND e.pais.id=:id");
        query.setParameter("nome", dto.getNome());
        query.setParameter("id", dto.getIdPais());
        List<?> list = query.getResultList();
        return list.isEmpty();

    }

}

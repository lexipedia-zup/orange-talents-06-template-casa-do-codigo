package br.com.zup.academy.casadocodigo.validations;

import br.com.zup.academy.casadocodigo.cliente.ClienteRequestDto;
import br.com.zup.academy.casadocodigo.estado.Estado;
import br.com.zup.academy.casadocodigo.estado.EstadoRepository;
import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.pais.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

public class EstadoPertencePaisValidator implements ConstraintValidator<EstadoPertencePais, ClienteRequestDto> {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void initialize(EstadoPertencePais constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClienteRequestDto dto, ConstraintValidatorContext context) {
        Query query = em.createQuery("SELECT 1 FROM Estado e WHERE e.pais.id=:id");
        query.setParameter("id", dto.getIdPais());
        List<?> list = query.getResultList();
        Optional<Estado> estado = estadoRepository.findById(dto.getIdEstado());
        Pais pais = paisRepository.findById(dto.getIdPais()).get();

        if(list.isEmpty() && estado.isEmpty()){
            return true;
        }

        if(!list.isEmpty() && estado.isPresent() && estado.get().pertence(pais)){
            return true;
        }

        return false;
    }
}

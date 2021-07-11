package br.com.zup.academy.casadocodigo.estado;

import br.com.zup.academy.casadocodigo.pais.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    Optional<Estado> findByNomeAndPais(String nome, Pais pais);

}

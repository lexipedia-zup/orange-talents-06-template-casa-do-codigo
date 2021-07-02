package br.com.zup.academy.casadocodigo.autor;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Integer> {

    Optional<Autor> findByEmail(String email);

}

package br.com.zup.academy.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Integer> {

    Optional<Autor> findByEmail(String email);

}

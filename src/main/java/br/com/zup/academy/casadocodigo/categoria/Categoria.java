package br.com.zup.academy.casadocodigo.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;

    public Categoria(CategoriaRequestDto categoriaRequestDto) {
        this.nome = categoriaRequestDto.getNome();
    }
}

package br.com.zup.academy.casadocodigo.categoria;

import br.com.zup.academy.casadocodigo.validations.Unique;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;


public class CategoriaRequestDto {

    @NotBlank
    @Unique(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequestDto(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}

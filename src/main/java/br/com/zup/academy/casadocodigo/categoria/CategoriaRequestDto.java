package br.com.zup.academy.casadocodigo.categoria;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;


public class CategoriaRequestDto {

    @NotBlank
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoriaRequestDto(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toModel(CategoriaRequestDto categoriaRequestDto) {
        return new Categoria(categoriaRequestDto);
    }
}

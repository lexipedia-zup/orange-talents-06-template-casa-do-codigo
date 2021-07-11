package br.com.zup.academy.casadocodigo.pais;

import br.com.zup.academy.casadocodigo.validations.Unique;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class PaisRequestDto {

    @NotBlank
    @Unique(fieldName = "nome", domainClass = Pais.class)
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public PaisRequestDto(String nome){
        this.nome = nome;
    }

    public PaisRequestDto(){

    }

    public String getNome() {
        return nome;
    }

    public Pais toModel(PaisRequestDto dto){
        return new Pais(dto.getNome());
    }

}

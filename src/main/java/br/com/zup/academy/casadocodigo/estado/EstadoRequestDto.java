package br.com.zup.academy.casadocodigo.estado;

import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.validations.Existe;
import br.com.zup.academy.casadocodigo.validations.Unique;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class EstadoRequestDto {

    @NotBlank
    @Unique(domainClass = Estado.class, fieldName = "nome")
    private String nome;

    @NotNull
    @Existe(domainClass = Pais.class, fieldName = "id")
    private Integer idPais;

    public EstadoRequestDto() {

    }

    public String getNome() {
        return nome;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Estado toModel(EstadoRequestDto dto, Pais pais){
        Estado estado = new Estado(dto.getNome(), pais);
        return estado;
    }
}

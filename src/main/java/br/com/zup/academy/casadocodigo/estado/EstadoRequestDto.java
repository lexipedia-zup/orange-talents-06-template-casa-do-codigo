package br.com.zup.academy.casadocodigo.estado;

import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.validations.Existe;
import br.com.zup.academy.casadocodigo.validations.EstadoPaisUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EstadoPaisUnico
public class EstadoRequestDto{

    @NotBlank
    private String nome;

    @NotNull(message = "Um estado deve estar vinculado à um país")
    @Existe(domainClass = Pais.class, fieldName = "id", message = "País não cadastrado")
    private Integer idPais;

    public EstadoRequestDto() {

    }

    public String getNome() {
        return nome;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Estado toModel( Pais pais){
        Estado estado = new Estado(this.nome, pais);
        return estado;
    }

}

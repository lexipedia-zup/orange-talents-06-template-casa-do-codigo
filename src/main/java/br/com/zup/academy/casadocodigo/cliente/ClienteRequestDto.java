package br.com.zup.academy.casadocodigo.cliente;

import br.com.zup.academy.casadocodigo.estado.Estado;
import br.com.zup.academy.casadocodigo.pais.Pais;
import br.com.zup.academy.casadocodigo.validations.*;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ObrigatoriedadeEstado
@EstadoPertencePais
public class ClienteRequestDto {

    @Email
    @Unique(fieldName = "email", domainClass = Cliente.class)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @CpfOrCnpj
    @NotBlank
    @Unique(fieldName = "documento", domainClass = Cliente.class)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    private Integer idEstado;

    @Existe(fieldName = "id", domainClass = Pais.class)
    @NotNull
    private Integer idPais;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @Deprecated
    public ClienteRequestDto(){

    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ClienteRequestDto(@Email @NotBlank String email,
                             @NotBlank String nome, @NotBlank String sobrenome,
                             @NotBlank String documento, @NotBlank String endereco,
                             @NotBlank String complemento, @NotBlank String cidade,
                             Integer idEstado, @NotNull Integer idPais, @NotBlank String telefone,
                             @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Integer getIdEstado() {
        if(this.idEstado == null){
            return 0;
        }
        return idEstado;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public Cliente toModel(Estado estado, Pais pais){

        return new Cliente(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                estado,
                pais,
                this.telefone,
                this.cep);
    }

}

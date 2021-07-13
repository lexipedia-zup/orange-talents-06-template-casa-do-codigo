package br.com.zup.academy.casadocodigo.cliente;

import br.com.zup.academy.casadocodigo.estado.Estado;
import br.com.zup.academy.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    private String telefone;
    private String cep;

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String documento,
                   String endereco,
                   String complemento,
                   String cidade,
                   Estado estado,
                   Pais pais,
                   String telefone,
                   String cep){

        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Deprecated
    public Cliente(){

    }

    public Integer getId() {
        return id;
    }
}

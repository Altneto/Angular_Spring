package com.maxima.avaliacao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_codigo", referencedColumnName = "codigo")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String cnpj, Endereco endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigo.equals(cliente.codigo) && nome.equals(cliente.nome) && cnpj.equals(cliente.cnpj) && endereco.equals(cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, cnpj, endereco);
    }
}

package com.maxima.avaliacao.vo;

import com.maxima.avaliacao.models.Endereco;

public class ClienteVO {

    private Long codigo;
    private String nome;
    private Endereco endereco;

    public ClienteVO() {
    }

    public ClienteVO(Long codigo, String nome, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

package com.maxima.avaliacao.vo;

import com.maxima.avaliacao.models.Endereco;

public class ClienteCompletoVO {
    private Long codigo;
    private String nome;
    private String cnpj;
    private Endereco endereco;

    public ClienteCompletoVO() {
    }

    public ClienteCompletoVO(Long codigo, String nome, String cnpj, Endereco endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
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
}

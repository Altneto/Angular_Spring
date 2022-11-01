package com.maxima.avaliacao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long codigo;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    public Endereco() {}

    public Endereco(Long codigo, String latitude, String longitude, Cliente cliente) {
        this.codigo = codigo;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cliente = cliente;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return codigo.equals(endereco.codigo) && latitude.equals(endereco.latitude) && longitude.equals(endereco.longitude) && cliente.equals(endereco.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, latitude, longitude, cliente);
    }
}

package com.maxima.avaliacao.services;

import com.maxima.avaliacao.models.Endereco;
import com.maxima.avaliacao.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco stringToEndereco(String local) {
        Endereco endereco = new Endereco();
        local = local.trim().replaceAll("\\s+", " ");
        String[] divisor = local.split("\\,");
        String lat = divisor[0];
        String lng = divisor[1];
        endereco.setLatitude(lat);
        endereco.setLongitude(lng);

        return endereco;
    }
}

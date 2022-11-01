package com.maxima.avaliacao.exceptions;

import java.io.Serializable;
import java.time.LocalDate;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate data;
    private String mensagem;
    private String detalhes;

    private String uri;

    public ExceptionResponse(LocalDate data, String mensagem, String detalhes, String uri) {
        this.data = data;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
        this.uri = uri;
    }

    public LocalDate getData() {
        return data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public String getUri() {
        return uri;
    }
}

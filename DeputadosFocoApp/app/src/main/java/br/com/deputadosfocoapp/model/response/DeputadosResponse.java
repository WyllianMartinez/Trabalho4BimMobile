package br.com.deputadosfocoapp.model.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import br.com.deputadosfocoapp.model.Deputados;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeputadosResponse {
    @JsonProperty("dados")
    private List<Deputados> dados;

    public List<Deputados> getDados() {
        return dados;
    }

    public void setDados(List<Deputados> dados) {
        this.dados = dados;
    }
}
package br.com.deputadosfocoapp.model.response;

import java.util.List;

import br.com.deputadosfocoapp.model.Partidos;

public class PartidosResponse {

    private List<Partidos> dados;

    private List<Object> links;

    public PartidosResponse() {
    }

    public PartidosResponse(List<Partidos> dados, List<Object> links) {
        this.dados = dados;
        this.links = links;
    }

    public List<Partidos> getDados() {
        return dados;
    }

    public void setDados(List<Partidos> dados) {
        this.dados = dados;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}

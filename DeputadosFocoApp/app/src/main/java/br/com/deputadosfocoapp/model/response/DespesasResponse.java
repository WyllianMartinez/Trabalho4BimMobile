package br.com.deputadosfocoapp.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import br.com.deputadosfocoapp.model.Despesas;

public class DespesasResponse {

    List<Despesas> dados;

    private List<Object> links;

    public DespesasResponse() {
    }

    public DespesasResponse(List<Despesas> dados, List<Object> links) {
        this.dados = dados;
        this.links = links;
    }

    public List<Despesas> getDados() {
        return dados;
    }

    public void setDados(List<Despesas> dados) {
        this.dados = dados;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }
}

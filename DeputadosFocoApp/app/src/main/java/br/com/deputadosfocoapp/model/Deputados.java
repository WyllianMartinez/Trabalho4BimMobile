package br.com.deputadosfocoapp.model;


public class Deputados {
    private String id;
    private String uri;
    private String uriPartido;
    private String nome;
    private String siglaPartido;
    private String siglaUf;
    private String idLegislatura;
    private String urlFoto;
    private String email;

    public Deputados() {
    }

    public Deputados(String id, String uri, String uriPartido, String nome, String siglaPartido, String siglaUf, String idLegislatura, String urlFoto, String email) {
        this.id = id;
        this.uri = uri;
        this.uriPartido = uriPartido;
        this.nome = nome;
        this.siglaPartido = siglaPartido;
        this.siglaUf = siglaUf;
        this.idLegislatura = idLegislatura;
        this.urlFoto = urlFoto;
        this.email = email;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUriPartido() {
        return uriPartido;
    }

    public void setUriPartido(String uriPartido) {
        this.uriPartido = uriPartido;
    }

    public String getIdLegislatura() {
        return idLegislatura;
    }

    public void setIdLegislatura(String idLegislatura) {
        this.idLegislatura = idLegislatura;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaPartido() {
        return siglaPartido;
    }

    public void setSiglaPartido(String siglaPartido) {
        this.siglaPartido = siglaPartido;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
package br.com.deputadosfocoapp.model;

public class Partidos {
        private int id;
        private String sigla;
        private String nome;
        private String uri;

        public Partidos() {
        }

        public Partidos(int id, String sigla, String nome, String uri) {
            this.id = id;
            this.sigla = sigla;
            this.nome = nome;
            this.uri = uri;
        }

        public int getId() {
            return id;
        }

        public String getSigla() {
            return sigla;
        }

        public String getNome() {
            return nome;
        }

        public String getUri() {
            return uri;
        }
}

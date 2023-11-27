package br.com.deputadosfocoapp.model;

public class Despesas {
    private int ano;
    private String cnpjCpfFornecedor;
    private int codDocumento;
    private int codLote;
    private int codTipoDocumento;
    private String dataDocumento;
    private int mes;
    private String nomeFornecedor;
    private String numDocumento;
    private String numRessarcimento;
    private int parcela;
    private String tipoDespesa;
    private String tipoDocumento;
    private String urlDocumento;
    private double valorDocumento;
    private double valorGlosa;
    private double valorLiquido;

    public Despesas(){

    }
    public Despesas(int ano, String cnpjCpfFornecedor, int codDocumento, int codLote,
                    int codTipoDocumento, String dataDocumento, int mes, String nomeFornecedor,
                    String numDocumento, String numRessarcimento, int parcela, String tipoDespesa,
                    String tipoDocumento, String urlDocumento, double valorDocumento,
                    double valorGlosa, double valorLiquido) {
        this.ano = ano;
        this.cnpjCpfFornecedor = cnpjCpfFornecedor;
        this.codDocumento = codDocumento;
        this.codLote = codLote;
        this.codTipoDocumento = codTipoDocumento;
        this.dataDocumento = dataDocumento;
        this.mes = mes;
        this.nomeFornecedor = nomeFornecedor;
        this.numDocumento = numDocumento;
        this.numRessarcimento = numRessarcimento;
        this.parcela = parcela;
        this.tipoDespesa = tipoDespesa;
        this.tipoDocumento = tipoDocumento;
        this.urlDocumento = urlDocumento;
        this.valorDocumento = valorDocumento;
        this.valorGlosa = valorGlosa;
        this.valorLiquido = valorLiquido;
    }

    public int getAno() {
        return ano;
    }

    public String getCnpjCpfFornecedor() {
        return cnpjCpfFornecedor;
    }

    public int getCodDocumento() {
        return codDocumento;
    }

    public int getCodLote() {
        return codLote;
    }

    public int getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public int getMes() {
        return mes;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getNumRessarcimento() {
        return numRessarcimento;
    }

    public int getParcela() {
        return parcela;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public double getValorDocumento() {
        return valorDocumento;
    }

    public double getValorGlosa() {
        return valorGlosa;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }
}

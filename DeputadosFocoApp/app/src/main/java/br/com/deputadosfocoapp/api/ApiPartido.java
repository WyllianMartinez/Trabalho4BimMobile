package br.com.deputadosfocoapp.api;

import java.util.List;

import br.com.deputadosfocoapp.model.DadosDespesa;
import br.com.deputadosfocoapp.model.Partidos;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiPartido {

    @GET("partidos")
    Call<List<Partidos>> GET_PARTIDOS();

    @GET("deputados/{id}/despesas")
    Call<List<DadosDespesa>> GET_GASTOS_PARTIDO(@Path("id")Long id);

}

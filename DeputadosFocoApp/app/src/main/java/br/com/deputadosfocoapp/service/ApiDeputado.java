package br.com.deputadosfocoapp.service;

import br.com.deputadosfocoapp.model.Despesas;
import br.com.deputadosfocoapp.model.response.DeputadosResponse;
import br.com.deputadosfocoapp.model.response.DespesasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiDeputado {

    @GET("deputados")
    Call<DeputadosResponse> getDeputados(@Query("siglaPartido") String siglaPartido, @Query("nome") String nome, @Query("siglaUf") String siglaEstado,
                                         @Query("siglaSexo") String siglaSexo);

    @GET("deputados/{id}/despesas")
    Call<DespesasResponse> getGastosDeputados(@Path("id") int id);
}

package br.com.deputadosfocoapp.api;

import br.com.deputadosfocoapp.response.DeputadosResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiDeputado {

        @GET("deputados")
        Call<DeputadosResponse> GET_DEPUTADOS_PATH(@Query("siglaPartido") String siglaPartido, @Query("nome") String nome, @Query("siglaUf") String siglaEstado,
                                               @Query("siglaSexo") String siglaSexo);
}

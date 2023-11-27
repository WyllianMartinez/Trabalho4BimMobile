package br.com.deputadosfocoapp.service;

import java.util.List;

import br.com.deputadosfocoapp.model.Partidos;
import br.com.deputadosfocoapp.model.response.PartidosResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiPartido {

    @GET("partidos")
    Call<PartidosResponse> getPartidos();

}

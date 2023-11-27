package br.com.deputadosfocoapp.retrofit;

import br.com.deputadosfocoapp.service.ApiDeputado;
import br.com.deputadosfocoapp.service.ApiPartido;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    public static String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private static retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    public static ApiDeputado apiDeputados() {
        return retrofit.create(ApiDeputado.class);
    }
    public static ApiPartido apiPartido() { return  retrofit.create(ApiPartido.class); }

}

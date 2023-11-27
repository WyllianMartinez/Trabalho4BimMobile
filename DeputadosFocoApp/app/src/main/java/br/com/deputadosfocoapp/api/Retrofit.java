package br.com.deputadosfocoapp.api;

import retrofit2.converter.jackson.JacksonConverterFactory;

public class Retrofit {
    public static String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2/";
    private static retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();
    public static ApiDeputado GET_DEPUTADOS_PATH() {
        return retrofit.create(ApiDeputado.class);
    }
    public static ApiPartido GET_PARTIDOS() { return  retrofit.create(ApiPartido.class); }
    public static ApiPartido GET_GASTOS_PARTIDO() { return  retrofit.create(ApiPartido.class);}


}

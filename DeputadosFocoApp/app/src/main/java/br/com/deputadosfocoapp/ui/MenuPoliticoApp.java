package br.com.deputadosfocoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.adapter.DespesasAdapter;
import br.com.deputadosfocoapp.adapter.PartidosAdapter;
import br.com.deputadosfocoapp.model.Partidos;
import br.com.deputadosfocoapp.model.response.DespesasResponse;
import br.com.deputadosfocoapp.model.response.PartidosResponse;
import br.com.deputadosfocoapp.retrofit.RetrofitConfig;
import br.com.deputadosfocoapp.service.ApiDeputado;
import br.com.deputadosfocoapp.service.ApiPartido;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuPoliticoApp extends AppCompatActivity {

    private List<Partidos> listaPartido;

    private RecyclerView rvDespesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_politico_app);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lista de Deputados");

        rvDespesas = findViewById(R.id.rvDespesas);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_arrow_back_24, null);
        drawable.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);


        carregarPartidos();

    }


    private void carregarPartidos() {
        ApiPartido apiPartido = RetrofitConfig.apiPartido();

        Call<PartidosResponse> call = apiPartido.getPartidos();

        call.enqueue(new Callback<PartidosResponse>() {
            @Override
            public void onResponse(Call<PartidosResponse> call, Response<PartidosResponse> response) {
                if (response.isSuccessful()) {

                    PartidosResponse partidosResponse = response.body();

                    if (partidosResponse != null && partidosResponse.getDados() != null) {
                        listaPartido = partidosResponse.getDados();

                        PartidosAdapter partidosAdapter = new PartidosAdapter(listaPartido, MenuPoliticoApp.this);
                        rvDespesas.setLayoutManager(new LinearLayoutManager(MenuPoliticoApp.this));
                        rvDespesas.setAdapter(partidosAdapter);

                    } else {
                        Toast.makeText(MenuPoliticoApp.this, "Lista de deputados vazia ou nula!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("DEBUG", "Erro " + response.code() + " - "  + response.errorBody().toString());
                    Toast.makeText(MenuPoliticoApp.this, "Não foi possível carregar deputados! Verifique.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PartidosResponse> call, Throwable t) {
                Log.e("onFailure", "" + t.getMessage());
                Toast.makeText(MenuPoliticoApp.this, "Verifique a conexão com o servidor!", Toast.LENGTH_SHORT).show();

                Log.d("DEBUG", "Erro " + t.getMessage());

            }
        });
    }
}
package br.com.deputadosfocoapp;

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

import java.util.ArrayList;
import java.util.List;

import br.com.deputadosfocoapp.adapter.DeputadosCardAdapter;
import br.com.deputadosfocoapp.api.ApiDeputado;
import br.com.deputadosfocoapp.api.Retrofit;
import br.com.deputadosfocoapp.model.Deputados;
import br.com.deputadosfocoapp.response.DeputadosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDeputadoApp extends AppCompatActivity {

    private List<Deputados> listaCardDeputado;
    private DeputadosCardAdapter deputadosCardAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_deputado_app);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lista de Deputados");

        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_arrow_back_24, null);
        drawable.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(drawable);

        recyclerView = findViewById(R.id.rvCardDeputado);
        deputadosCardAdapter = new DeputadosCardAdapter(new ArrayList<>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deputadosCardAdapter);

        carregarCardEscolta();
    }

    private void carregarCardEscolta() {
        ApiDeputado apiDeputado = Retrofit.GET_DEPUTADOS_PATH();

        Call<DeputadosResponse> call = apiDeputado.GET_DEPUTADOS_PATH("", "", "PR", "");

        call.enqueue(new Callback<DeputadosResponse>() {
            @Override
            public void onResponse(Call<DeputadosResponse> call, Response<DeputadosResponse> response) {
                if (response.isSuccessful()) {
                    DeputadosResponse deputadoResponse = response.body();

                    if (deputadoResponse != null && deputadoResponse.getDados() != null) {
                        listaCardDeputado = deputadoResponse.getDados();

                        // Atualize a lista no adaptador
                        deputadosCardAdapter.atualizarLista(listaCardDeputado);
                    } else {
                        Toast.makeText(MenuDeputadoApp.this, "Lista de deputados vazia ou nula!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MenuDeputadoApp.this, "Não foi possível carregar deputados! Verifique.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DeputadosResponse> call, Throwable t) {
                Log.e("onFailure", "" + t.getMessage());
                Toast.makeText(MenuDeputadoApp.this, "Verifique a conexão com o servidor!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

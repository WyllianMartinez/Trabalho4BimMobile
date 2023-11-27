package br.com.deputadosfocoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.adapter.DespesasAdapter;
import br.com.deputadosfocoapp.model.Despesas;
import br.com.deputadosfocoapp.model.response.DespesasResponse;
import br.com.deputadosfocoapp.retrofit.RetrofitConfig;
import br.com.deputadosfocoapp.service.ApiDeputado;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuGastosApp extends AppCompatActivity {

    private int idDeputado;

    private RecyclerView rvDespesas;

    private List<Despesas> listaDespesas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gastos_app);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null && bundle.containsKey("id_deputado")) {
                idDeputado = bundle.getInt("id_deputado");
                Log.d("DEBUG", "ID do Deputado recebido: " + idDeputado);
                carregarDespesas(idDeputado);
            } else {
                Log.d("DEBUG", "Bundle não contém 'id_deputado'");
            }
        } else {
            Log.d("DEBUG", "Intent é nula");
        }
        rvDespesas = findViewById(R.id.rvDespesas);
    }

    private void carregarDespesas(int idDeputado) {
        ApiDeputado apiDeputado = RetrofitConfig.apiDeputados();

        Call<DespesasResponse> call = apiDeputado.getGastosDeputados(idDeputado);

        call.enqueue(new Callback<DespesasResponse>() {
            @Override
            public void onResponse(Call<DespesasResponse> call, Response<DespesasResponse> response) {
                if (response.isSuccessful()) {
                    DespesasResponse despesasResponse = response.body();

                    if (despesasResponse != null && despesasResponse.getDados() != null) {
                        listaDespesas = despesasResponse.getDados();

                        DespesasAdapter despesasAdapter = new DespesasAdapter(listaDespesas, MenuGastosApp.this);
                        rvDespesas.setLayoutManager(new LinearLayoutManager(MenuGastosApp.this));
                        rvDespesas.setAdapter(despesasAdapter);

                    } else {
                        Toast.makeText(MenuGastosApp.this, "Lista de deputados vazia ou nula!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("DEBUG", "Deputado " + idDeputado);
                    Log.d("DEBUG", "Erro " + response.code() + " - "  + response.errorBody().toString());
                    Toast.makeText(MenuGastosApp.this, "Não foi possível carregar deputados! Verifique.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DespesasResponse> call, Throwable t) {
                Log.e("onFailure", "" + t.getMessage());
                Toast.makeText(MenuGastosApp.this, "Verifique a conexão com o servidor!", Toast.LENGTH_SHORT).show();

                Log.d("DEBUG", "Erro " + t.getMessage());

            }
        });
    }
}



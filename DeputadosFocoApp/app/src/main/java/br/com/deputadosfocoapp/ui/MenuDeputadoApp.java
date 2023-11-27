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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.deputadosfocoapp.R;
import br.com.deputadosfocoapp.adapter.DeputadosAdapter;
import br.com.deputadosfocoapp.service.ApiDeputado;
import br.com.deputadosfocoapp.retrofit.RetrofitConfig;
import br.com.deputadosfocoapp.model.Deputados;
import br.com.deputadosfocoapp.model.response.DeputadosResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDeputadoApp extends AppCompatActivity {

    private List<Deputados> listaCardDeputado;
    private DeputadosAdapter deputadosCardAdapter;
    private RecyclerView recyclerView;

    private EditText edNome;
    private Spinner spUf, spPartido, spSexo;

    private Button btnFiltrar;
    private ProgressBar progressBar;

    private String uf, sexo, partido;

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

        edNome = findViewById(R.id.edNome);
        spUf = findViewById(R.id.spUf);
        spPartido = findViewById(R.id.spPartido);
        spSexo = findViewById(R.id.spSexo);
        btnFiltrar = findViewById(R.id.btnFiltrar);

        progressBar = findViewById(R.id.progressBar);

        recyclerView = findViewById(R.id.rvCardDeputado);
        deputadosCardAdapter = new DeputadosAdapter(new ArrayList<>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(deputadosCardAdapter);

        String[] ufSiglas = getResources().getStringArray(R.array.uf_siglas);
        ArrayAdapter<String> adapterUf = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ufSiglas);
        adapterUf.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUf.setAdapter(adapterUf);

        String[] partidoSiglas = getResources().getStringArray(R.array.partido_siglas);
        ArrayAdapter<String> adapterPartido = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, partidoSiglas);
        adapterPartido.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPartido.setAdapter(adapterPartido);

        String[] siglaSexo = getResources().getStringArray(R.array.sexo);
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, siglaSexo);
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSexo.setAdapter(adapterSexo);

        spSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                sexo = siglaSexo[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spUf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                uf = ufSiglas[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        spPartido.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                partido = partidoSiglas[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                if ("Ambos".equals(sexo)) {
                    sexo = null;
                }

                if ("Masculino".equals(sexo)) {
                    sexo = "M";
                }
                if ("Feminino".equals(sexo)) {
                    sexo = "F";
                }

                if ("Todos".equals(partido)) {
                    partido = null;
                }

                if ("Todos".equals(uf)) {
                    uf = null;
                }

                Log.d("DEBUG", "Uf: " + uf + " PARTIDO " + partido + " Sexo " + sexo);

                carregarCardEscolta(edNome.getText().toString(), partido, uf, sexo);
            }
        });

    }

    private void carregarCardEscolta(String nome, String partido, String estado, String sexo) {
        ApiDeputado apiDeputado = RetrofitConfig.apiDeputados();

        Call<DeputadosResponse> call = apiDeputado.getDeputados(partido, nome, estado, sexo);

        call.enqueue(new Callback<DeputadosResponse>() {
            @Override
            public void onResponse(Call<DeputadosResponse> call, Response<DeputadosResponse> response) {
                if (response.isSuccessful()) {
                    DeputadosResponse deputadoResponse = response.body();

                    if (deputadoResponse != null && deputadoResponse.getDados() != null) {
                        listaCardDeputado = deputadoResponse.getDados();

                        deputadosCardAdapter.atualizarLista(listaCardDeputado);
                    } else {
                        Toast.makeText(MenuDeputadoApp.this, "Lista de deputados vazia ou nula!", Toast.LENGTH_SHORT).show();
                    }

                    progressBar.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MenuDeputadoApp.this, "Não foi possível carregar deputados! Verifique.", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
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

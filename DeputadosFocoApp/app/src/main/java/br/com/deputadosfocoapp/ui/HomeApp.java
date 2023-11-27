package br.com.deputadosfocoapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.deputadosfocoapp.R;

public class HomeApp extends AppCompatActivity {
    private Button btnPartido;
    private Button btnDeputado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Deputados em Foco");


        btnPartido = findViewById(R.id.btnPartido);
        btnDeputado = findViewById(R.id.btnDeputado);

        btnPartido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent( HomeApp.this, MenuPoliticoApp.class);
                startActivity(intent);

            }
        });

        btnDeputado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeApp.this, MenuDeputadoApp.class);
                startActivity(intent);

            }
        });
    }
}
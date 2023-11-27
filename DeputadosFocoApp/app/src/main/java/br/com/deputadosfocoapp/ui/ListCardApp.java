package br.com.deputadosfocoapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.deputadosfocoapp.R;

public class ListCardApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_deputados);
    }
}
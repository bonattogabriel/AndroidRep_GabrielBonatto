package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private double resultado;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.resultado);
        Intent i = getIntent();
        resultado = i.getDoubleExtra("resultado", 0);
        tvResultado.setText("" + resultado);
    }
    public void btSairOnClick(View view) {
        finish();
    }
}

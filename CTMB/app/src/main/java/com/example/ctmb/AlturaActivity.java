package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AlturaActivity extends AppCompatActivity {

    private EditText etAltura;
    String peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altura);

        etAltura = findViewById(R.id.etAltura);

        Intent i = getIntent();
        peso = i.getStringExtra("peso");
    }

    public void btProximoAlturaOnClick(View view){
        Double alt = Double.parseDouble(etAltura.getText().toString());
        if (etAltura.getText() == null || etAltura.getText().toString().equals("")){
            etAltura.setError("Informe a altura!");
        } else{
            if (alt <= 0 || alt >= 3.00){
                etAltura.setError("Informe uma altura válida!");
            } else{
                Intent i = new Intent(this, SexoActivity.class);
                i.putExtra("peso", peso);
                i.putExtra("altura", etAltura.getText().toString());
                startActivity(i);
            }
        }
    }
}

package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Cálculo da Taxa Metabólica Basal");

        etPeso = findViewById(R.id.etPeso);
    }

    public void btProxOnClick(View view) {

        if (etPeso.getText() == null || etPeso.getText().toString().equals("")){
            etPeso.setError("Informe o peso.");
        } else {

            Double peso = Double.parseDouble(etPeso.getText().toString());

            if (peso <= 0 || peso >= 500){
                etPeso.setError("Informe um peso válido!");
            } else {
                Intent i = new Intent(this, AlturaActivity.class);
                i.putExtra("peso", etPeso.getText().toString());
                startActivity(i);
            }
        }
    }
}

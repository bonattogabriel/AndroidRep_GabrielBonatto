package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class IdadeActivity extends AppCompatActivity {

    private EditText etIdade;
    String sexo, altura, peso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idade);

        etIdade = findViewById(R.id.etIdade);

        Intent i = getIntent();

        altura = i.getStringExtra("altura");
        peso = i.getStringExtra("peso");
        sexo = i.getStringExtra("sexo");

    }

    public void btProximoIdadeOnClick(View view){

        int idade = Integer.parseInt(etIdade.getText().toString());

        if (etIdade.getText() == null || etIdade.getText().toString().equals("")){
            etIdade.setError("Informe o Sexo!");
        } else{
            if (idade <= 0 || idade > 150){
                etIdade.setError("Informe uma idade válida");
            } else{
                Intent i = new Intent(this, NAFActivity.class);
                i.putExtra("peso", peso);
                i.putExtra("altura", altura);
                i.putExtra("sexo", sexo);
                i.putExtra("idade", etIdade.getText().toString());
                startActivity(i);
            }
        }
    }
}

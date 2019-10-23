package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SexoActivity extends AppCompatActivity {

    private EditText etSexo;
    String peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexo);

        etSexo = findViewById(R.id.etSexo);

        Intent i = getIntent();
        peso = i.getStringExtra("peso");
        altura = i.getStringExtra("altura");
    }

    public void btProximoSexoOnClick(View view){
        if (etSexo.getText() == null || etSexo.getText().toString().equals("")){
            etSexo.setError("Informe o Sexo!");
        } else{
            if (etSexo.getText().toString().equals("F") || etSexo.getText().toString().equals("M")){
                Intent i = new Intent(this, IdadeActivity.class);
                i.putExtra("peso", peso);
                i.putExtra("altura", altura);
                i.putExtra("sexo", etSexo.getText().toString());
                startActivity(i);
            } else {
                etSexo.setError("Informe M ou F!");
            }

        }
    }
}

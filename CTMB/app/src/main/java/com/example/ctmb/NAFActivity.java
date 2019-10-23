package com.example.ctmb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NAFActivity extends AppCompatActivity {

    private EditText etCodAF;
    private double resultado;
    Double altura, peso;
    int idade;
    String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naf);

        etCodAF = findViewById(R.id.etCodAF);

        Intent i = getIntent();
        sexo = i.getStringExtra("sexo");
        idade = i.getIntExtra("idade",0);
        altura = i.getDoubleExtra("altura", 0);
        peso = i.getDoubleExtra("peso", 0);

    }

    public void btPesquisarNAFOnClick(View view){
        Intent i = new Intent( this, ListaNAFActivity.class);
        startActivityForResult(i, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode == 1){
            if (resultCode == 0){
                if (data != null){
                    int cod = data.getIntExtra("cod", 0);
                    etCodAF.setText(String.valueOf(cod));
                }
            }
        }
    }

    public void btProximoNAFOnClick(View view){
        int naf = Integer.parseInt(etCodAF.getText().toString());
        if (etCodAF.getText() == null || etCodAF.getText().toString().equals("")){
            etCodAF.setError("Informe o nível de atividade física!");
        } else{
            if (naf < 1 || naf > 5){
                etCodAF.setError("Informe um valor entre 1 e 5!");
            } else {
                if(sexo.equals("M")){
                    resultado = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
                } else{
                    resultado = 65 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
                }
                Intent i = new Intent(this, ResultadoActivity.class);
                i.putExtra("resultado", resultado);
                startActivity(i);
            }
        }
    }
}

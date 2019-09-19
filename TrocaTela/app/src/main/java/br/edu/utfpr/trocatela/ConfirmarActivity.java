package br.edu.utfpr.trocatela;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {

    private TextView tvCod;
    private TextView tvQtd;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        tvCod = findViewById(R.id.tvCod);       //Busca o componente da tela no XML
        tvQtd = findViewById(R.id.tvQtd);       //Busca o componente da tela no XML
        tvValor = findViewById(R.id.tvValor);   //Busca o componente da tela no XML

        Intent i = getIntent(); // busca os valores setados no LancamentoActivity

        int cod = i.getIntExtra("cod", 0);
        double qtd = i.getDoubleExtra("qtd", 0);
        double valor = i.getDoubleExtra("valor", 0);

        tvCod.setText(String.valueOf(cod));
        tvQtd.setText(String.valueOf(qtd));
        tvValor.setText(String.valueOf(valor));
    }

    public void btConfirmarFinalOnClick(View v) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Erro");
        alerta.setMessage("Erro ao enviar dados para o Servidor!");
        alerta.setCancelable(false);
        alerta.setNeutralButton("OK",null);
        alerta.show();
    }
}

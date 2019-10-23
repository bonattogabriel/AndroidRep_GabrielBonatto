package br.edu.utfpr.praticarevisao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HistoricoActivity extends AppCompatActivity {

    private String aux = "";
    private TextView tvHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        tvHistorico = findViewById(R.id.tvHistorico);

        Intent i = getIntent();
        tvHistorico.setText(i.getStringExtra("historico"));
    }
}

package br.edu.utfpr.trocatela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btLancamentoOnClick(View v) {
        Intent i = new Intent(this,LancamentoActivity.class);
        startActivity(i);
    }

    public void btSairOnClick(View v) {
        finish();
    }
}

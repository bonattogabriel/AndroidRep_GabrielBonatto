package br.edu.utfpr.trocatela;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LancamentoActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etQtd;
    private EditText etValor;

    private static final int LISTAR_BEBIDA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        etCod = findViewById(R.id.etCod);
        etQtd = findViewById(R.id.etQtd);
        etValor = findViewById(R.id.etValor);
    }

    public void btConfirmarOnClick(View view) {
        Intent i = new Intent(this,ConfirmarActivity.class);
        i.putExtra("cod", Integer.parseInt(etCod.getText().toString()));
        i.putExtra("qtd", Double.parseDouble(etQtd.getText().toString()));
        i.putExtra("valor", Double.parseDouble(etValor.getText().toString()));
        startActivity(i);
    }

    public void btListarOnClick(View view) {
        Intent i = new Intent(this, ListarActivity.class);
        startActivityForResult(i,LISTAR_BEBIDA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == LISTAR_BEBIDA) {
            if(resultCode == 0) {
                if(data != null) {
                    int cod = data.getIntExtra("cod",0);
                    etCod.setText(String.valueOf(cod));
                }
            }
        }
    }
}

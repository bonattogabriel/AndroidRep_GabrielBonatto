package br.edu.utfpr.avaliacao2samuel;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase banco;

    private Button btPesquisar;
    private EditText etCodCombustivel;
    private EditText etCidadeAbastecimento;
    private EditText etQtdeLitros;
    private static final int LISTA_COMBUSTIVEIS = 1;

    private int aux = 0;
    private int totalReg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btPesquisar = findViewById(R.id.btPesquisar);
        etCodCombustivel = findViewById(R.id.etCodCombustivel);
        etCidadeAbastecimento = findViewById(R.id.etCidadeAbastecimento);
        etQtdeLitros = findViewById(R.id.etQtdeLitros);

        banco = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS tipoGasolina (_id INTEGER PRIMARY KEY, tipo TEXT)");
        if(!jaExisteRegistro()) {
            banco.execSQL("INSERT INTO tipoGasolina VALUES(1,'Gasolina'),(2,'Etanol'),(3,'Diesel'),(4,'Gás Natural')");
        }
        banco.execSQL("CREATE TABLE IF NOT EXISTS regGasolina (_id INTEGER PRIMARY KEY AUTOINCREMENT, codCombustivel INTEGER," +
                " cidadeAbastecimento TEXT, qtdeLitro REAL)");
    }

    public void btPesquisarOnClick(View view) {
        startActivityForResult(new Intent(this,PesquisaCombustivelActivity.class),LISTA_COMBUSTIVEIS);
    }

    private boolean jaExisteRegistro(){
        int i = 0;
        Cursor reg = banco.query("tipoGasolina",
                null,null,null,null,null,null);

        if(reg.moveToNext()) {
            i++;
        }
        if(i >= 1) {
            return true;
        } else {
            return false;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == LISTA_COMBUSTIVEIS) {
            if(resultCode == 0) {
                if(data != null) {
                    int cod = data.getIntExtra("cod",0);
                    etCodCombustivel.setText(String.valueOf(cod));
                }
            }
        }
    }

    public void btIncluirOnClick(View view) {
        ContentValues reg = new ContentValues();
        reg.put("codCombustivel", etCodCombustivel.getText().toString());
        reg.put("cidadeAbastecimento",etCidadeAbastecimento.getText().toString());
        reg.put("qtdeLitro", etQtdeLitros.getText().toString());

        banco.insert("regGasolina", null,reg);
        aux = countBanco();

        Toast.makeText(this, "Registro Inserido com Sucesso!" + "\nQtde Total: " + aux, Toast.LENGTH_LONG).show();
        limpaCampos();
    }

    private int countBanco() {
        Cursor reg = banco.query("regGasolina",
                null,null,null,null,null,null);


        if(reg.moveToNext()) {
            totalReg++;
        }
        return totalReg;
    }

    private void limpaCampos() {
        etCodCombustivel.setText("");
        etCidadeAbastecimento.setText("");
        etQtdeLitros.setText("");
    }

    public void btListarOnClick(View view) {
        startActivity(new Intent(this,ListarActivity.class));
    }
}

package br.edu.utfpr.avaliacao2samuel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListarActivity extends AppCompatActivity {

    private SQLiteDatabase banco;
    private ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        banco = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);

        Cursor reg = banco.query("regGasolina",null,
                null,null,null,null,null);

        lvLista = findViewById(R.id.lvLista);

        MeuAdapter meuAdapter = new MeuAdapter(this,reg);

        lvLista.setAdapter(meuAdapter);
    }
}

package br.edu.utfpr.avaliacao2samuel;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class PesquisaCombustivelActivity extends AppCompatActivity {

    private ListView lvCombustiveis;
    private EditText etCodCombustivel;
    private SQLiteDatabase banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_combustivel);

        lvCombustiveis = findViewById(R.id.lvCombustiveis);

        banco = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        Cursor reg = banco.query("tipoGasolina",null,null,
                null,null,null,null);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1, reg,
                new String[] {"tipo"}, new int[] {android.R.id.text1});

        lvCombustiveis.setAdapter(adapter);

        lvCombustiveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int cod = position + 1;
                Intent i = getIntent();
                i.putExtra("cod",cod);
                setResult(0,i);
                finish();
            }
        });

    }
}

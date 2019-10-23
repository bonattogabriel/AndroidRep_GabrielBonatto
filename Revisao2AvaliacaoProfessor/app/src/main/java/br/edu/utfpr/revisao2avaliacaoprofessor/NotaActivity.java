package br.edu.utfpr.revisao2avaliacaoprofessor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity {
    
    private Spinner spDisciplina;
    private EditText etNota;
    
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        
        spDisciplina = findViewById(R.id.spDisciplina);
        etNota = findViewById(R.id.etNota);

        bd = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS nota (_id INTEGER PRIMARY KEY AUTOINCREMENT, disciplina TEXT, nota REAL)");
        
        String elementos[] = montarListaSpinner();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, elementos);
        spDisciplina.setAdapter(adapter);
    }

    private String[] montarListaSpinner() {
        Cursor c = bd.query( "disciplina", new String[] {"nome"}, null, null, null, null, null );

        String registros[] = new String[ c.getCount() ];

        int i = 0;
        while ( c.moveToNext() ) {
            String nome = c.getString( c.getColumnIndex( "nome" ) );
            registros[i] = nome;
            i++;
        }
        return registros;
    }

    public void btIncluirOnClick(View view) {

        ContentValues reg = new ContentValues();
        reg.put("disciplina", spDisciplina.getSelectedItem().toString());
        reg.put("nota", etNota.getText().toString());

        if(jaExisteReg(spDisciplina.getSelectedItem().toString())) {
            bd.update("nota",reg,"disciplina = '" + spDisciplina.getSelectedItem().toString() +"'", null);
        } else {
            bd.insert("nota", null, reg);
        }

        Toast.makeText(this, "Nota Lançada com Sucesso!", Toast.LENGTH_LONG).show();
    }

    private boolean jaExisteReg(String disciplina) {
        Cursor reg = bd.query("nota",null,
                "disciplina = ?",
                new String[] {disciplina}, null, null, null);

        if(reg.moveToNext()) {
            return true;
        } else {
            return false;
        }
    }

    public void btListarOnClick(View view) {
        Cursor registros = bd.query("nota",null,null,
                null,null,null,null);

        ListView lista = new ListView(this);

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, registros,
                new String[] {"disciplina", "nota"}, new int[] {android.R.id.text1, android.R.id.text2});
        lista.setAdapter(adapter);

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Registros de Notas");
        alerta.setCancelable(false);
        alerta.setNeutralButton("Ok",null);
        alerta.setView(lista);
        alerta.show();
    }
}

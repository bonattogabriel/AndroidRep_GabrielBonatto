package br.edu.utfpr.avaliacao2revisao;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import br.edu.utfpr.avaliacao2revisao.model.DatabaseHandler;

public class CadNotaActivity extends AppCompatActivity {

    private EditText etNota;
    private Spinner spDisciplinas;
    private DatabaseHandler dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_nota);

        dao = new DatabaseHandler(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, dao.getDisciplinas());

        etNota = findViewById(R.id.etNota);
        spDisciplinas = findViewById(R.id.spDisciplinas);

        spDisciplinas.setAdapter(adapter);
    }

}

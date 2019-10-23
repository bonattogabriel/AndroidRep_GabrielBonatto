package br.edu.utfpr.revisao2avaliacaoprofessor;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisciplinaActivity extends AppCompatActivity {

    private EditText etDisciplina;

    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        etDisciplina = findViewById(R.id.etDisciplina);

        bd = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        bd.execSQL("CREATE TABLE IF NOT EXISTS disciplina (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT)");
    }

    public void btIncluirOnClick(View view) {
        ContentValues reg = new ContentValues();
        reg.put("nome", etDisciplina.getText().toString());
        bd.insert("disciplina",null, reg);
        Toast.makeText(this, "Inclusão Realizada com Sucesso!", Toast.LENGTH_LONG).show();
    }
}

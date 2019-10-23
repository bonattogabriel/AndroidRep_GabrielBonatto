package br.edu.utfpr.avaliacao2revisao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.utfpr.avaliacao2revisao.entidade.Disciplina;
import br.edu.utfpr.avaliacao2revisao.model.DatabaseHandler;

public class CadDisciplinaActivity extends AppCompatActivity {

    private EditText etDisciplina;

    private DatabaseHandler dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_disciplina);

        etDisciplina = findViewById(R.id.etDisciplina);

        dao = new DatabaseHandler(this);
    }

    public void btIncluirOnClick(View view) {
        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina(etDisciplina.getText().toString());
        disciplina.setNota(null);
        dao.incluir(disciplina);

        Toast.makeText(this, "Disciplina Salvo com Sucesso!", Toast.LENGTH_SHORT).show();
    }
}

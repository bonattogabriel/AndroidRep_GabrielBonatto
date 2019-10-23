package br.edu.utfpr.avaliacao2revisao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.utfpr.avaliacao2revisao.model.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    private ListView lvItens;
    private String elementos[] = {"Disciplina","Nota"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, elementos);

        lvItens = findViewById(R.id.lvPrincipal);
        lvItens.setAdapter(adapter);
        lvItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                trocarTelaItem(position);
            }
        });
    }

    private void trocarTelaItem(int position) {
        Intent i;

        if (position == 0) {
            i = new Intent(this, CadDisciplinaActivity.class);
            startActivity(i);
        } else if(position == 1) {
            i = new Intent(this,CadNotaActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Opção Inválida", Toast.LENGTH_SHORT).show();
        }
    }
}

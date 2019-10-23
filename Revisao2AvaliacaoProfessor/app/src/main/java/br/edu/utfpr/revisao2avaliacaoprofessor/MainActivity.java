package br.edu.utfpr.revisao2avaliacaoprofessor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lvPrincipal;
    private static final int DISCIPLINA_MENU = 0;
    private static final int NOTA_MENU = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPrincipal = findViewById(R.id.lvPrincipal);

        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tratarSelecao(position);
            }
        });
    }

    private void tratarSelecao(int position) {
        if(position == DISCIPLINA_MENU) {
            startActivity(new Intent(this, DisciplinaActivity.class));
        } else if(position == NOTA_MENU) {
            startActivity(new Intent(this, NotaActivity.class));
        }
    }
}

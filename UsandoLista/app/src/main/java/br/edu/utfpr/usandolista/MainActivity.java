package br.edu.utfpr.usandolista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvPrincipal;

    private String elementos[] = {"Incluir","Alterar","Excluir","Pesquisar","Listar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, elementos);

        lvPrincipal = findViewById(R.id.lvPrincipal);
        lvPrincipal.setAdapter(adapter);
        lvPrincipal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tratarItemLista(position);
            }
        });
    }

    private void tratarItemLista(int position) {
        Toast.makeText(this,"Item " +  "'" + elementos[position].toString() + "'" + " selecionado",
                Toast.LENGTH_LONG).show();
    }
}

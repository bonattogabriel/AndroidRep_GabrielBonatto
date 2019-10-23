package br.edu.utfpr.usandoeventoselecao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spAleatorio;
    private ImageView ivImagens;

    private static final String ELEMENTOS[] = {"Teste", "Favarim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spAleatorio = findViewById(R.id.spAleatorio);
        ivImagens = findViewById(R.id.imagens);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, ELEMENTOS);

        spAleatorio.setAdapter(adapter);
        ivImagens.setImageResource(R.mipmap.teste1_foreground);

        spAleatorio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spAleatorio.getSelectedItem().toString().equals("Teste")) {
                    ivImagens.setImageResource(R.mipmap.teste1_foreground);
                } else if(spAleatorio.getSelectedItem().toString().equals("Favarim")) {
                    ivImagens.setImageResource(R.mipmap.profbrabo_foreground);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}

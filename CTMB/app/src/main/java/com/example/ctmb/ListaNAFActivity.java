package com.example.ctmb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaNAFActivity extends AppCompatActivity {

    private ListView lvNAF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_naf);

        lvNAF = findViewById(R.id.lvNAF);

        lvNAF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                tratarProduto(position);
            }
        });
    }

    private void tratarProduto(int position) {
        int cod = position + 1;

        Intent i = getIntent();
        i.putExtra("cod", cod);
        setResult(0,i);

        finish();
    }
}

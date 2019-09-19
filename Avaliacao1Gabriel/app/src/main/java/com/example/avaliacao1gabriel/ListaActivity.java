package com.example.avaliacao1gabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListaActivity extends AppCompatActivity {

  private ListView lvNivelList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista);
    lvNivelList = findViewById(R.id.lvNivelList);

    lvNivelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        tratarNivel(position);
      }
    });
  }

  private void tratarNivel(int position){
    int cod = position + 1;

    Intent i = getIntent();

    i.putExtra("cod", cod);
    setResult(0, i);

    finish();
  }
}

package br.edu.utfpr.trocatela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListarActivity extends AppCompatActivity {

  private ListView lvBebidas;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_listar);

    lvBebidas = findViewById(R.id.lvBebidas);

    lvBebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tratarCliqueElemento(position);
      }
    });
  }

  private void tratarCliqueElemento(int position) {
    int cod = position + 1;
    Intent i = getIntent();
    i.putExtra("cod", cod);
    setResult(0, i);
    finish();
  }
}

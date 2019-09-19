package com.example.avaliacao1gabriel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private EditText etNivel;
  private TextView tvPlacar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    etNivel = findViewById(R.id.etNivel);
    tvPlacar = findViewById(R.id.tvPlacar);
  }

  public void btnNivelOnClick(View view) {
    Intent i = new Intent(this, ListaActivity.class);
    startActivityForResult(i, 1);
  }

  protected void onActivityResult(int RequestCode, int ResultCode, @Nullable Intent data){
    if(RequestCode == 1){
      if(ResultCode == 0){
        if(data != null){
          int cod = data.getIntExtra("cod", 0);
          etNivel.setText(String.valueOf(cod));
        }
      }
    }else{
      if(ResultCode == 0){
        if(data != null){
          int jogador1 = data.getIntExtra("jogador1", 0);
          int jogador2 = data.getIntExtra("jogador2", 0);
          tvPlacar.setText(String.valueOf(jogador1) + "   X   " + String.valueOf(jogador2));
        }
      }
    }

  }

  public void btnJogarOnClick(View view) {
    Intent i = new Intent(this, JogarActivity.class);

    startActivityForResult(i, 2);
  }
}

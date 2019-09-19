package com.example.avaliacao1gabriel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class JogarActivity extends AppCompatActivity {

  private TextView tvJogador1;
  private TextView tvJogador2;
  private int jogador1;
  private int jogador2;
  private int nivel = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_jogar);

    jogador1 = 0;
    jogador2 = 0;

    tvJogador1 = findViewById(R.id.tvJogador1);
    tvJogador2 = findViewById(R.id.tvJogador2);

  }

  public void btnJogar1OnClick(View view) {
    jogar(nivel);
  }

  public void btnJogar2OnClick(View view) {
    jogar(nivel);
  }

  public void jogar(int nivel){
    int rand = new Random().nextInt(61) + 20;
    int pontos = nivel == 1 ? 1 : nivel == 2 ? 2 : 4;

    if(rand <= 50){
      jogador2 += pontos;
      tvJogador2.setText(String.valueOf(jogador2) + " pontos");
    }else{
      jogador1 += pontos;
      tvJogador1.setText(String.valueOf(jogador1) + " pontos");
    }

    if(jogador1 >= 12 || jogador2 >= 12){
      finish();
    }
  }
}

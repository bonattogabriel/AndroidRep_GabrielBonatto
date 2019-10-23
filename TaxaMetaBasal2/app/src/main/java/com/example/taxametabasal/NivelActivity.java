package com.example.taxametabasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NivelActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nivel);
  }

  public void btnPesquisarNivelOnClick(View view) {
    Intent i = new Intent(this, PesquisarActivity.class);
    startActivity(i);
  }

  public void btnProximoNivelOnClick(View view) {

  }
}

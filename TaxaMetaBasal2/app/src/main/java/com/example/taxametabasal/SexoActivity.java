package com.example.taxametabasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SexoActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sexo);
  }

  public void btnProximoSexo(View view) {
    Intent i = new Intent(this, IdadeActivity.class);
    startActivity(i);
  }
}

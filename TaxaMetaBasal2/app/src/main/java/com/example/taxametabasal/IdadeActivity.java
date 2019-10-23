package com.example.taxametabasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IdadeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_idade);
  }

  public void btnProximoIdade(View view) {
    Intent i = new Intent(this,NivelActivity.class);
    startActivity(i);
  }
}

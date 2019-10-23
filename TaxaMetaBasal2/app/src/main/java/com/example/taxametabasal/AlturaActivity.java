package com.example.taxametabasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AlturaActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_altura2);
  }

  public void btnProximoAltura(View view) {
    Intent i = new Intent(this, SexoActivity.class);
    startActivity(i);
  }
}

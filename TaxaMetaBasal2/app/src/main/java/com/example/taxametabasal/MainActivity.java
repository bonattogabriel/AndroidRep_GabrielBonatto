package com.example.taxametabasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  private EditText etPeso;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    etPeso = findViewById(R.id.etPeso);

  }

  public void btnProximoPeso(View view) {
    Intent i = new Intent(this, AlturaActivity.class);

    i.putExtra("peso", Float.parseFloat( etPeso.getText().toString()));

    startActivity(i);
  }
}

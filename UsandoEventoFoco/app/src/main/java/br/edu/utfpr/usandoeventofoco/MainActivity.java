package br.edu.utfpr.usandoeventofoco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etTxt1;
    private EditText etTxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTxt1 = findViewById(R.id.etTxt1);
        etTxt2 = findViewById(R.id.etTxt2);

        etTxt1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    Toast.makeText(MainActivity.this, "etTexto1 Está Focado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "etTexto2 Está Focado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

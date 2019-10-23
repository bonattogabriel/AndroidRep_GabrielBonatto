package br.edu.utfpr.usandoeventotoque;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LinearLayout tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tela = findViewById(R.id.tela);

        tela.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                TextView tvInfo = new TextView(MainActivity.this);

                String msg = "";

                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    msg = "Pressionou a tela. ";
                } else if(event.getAction() == MotionEvent.ACTION_UP) {
                    msg = "soltou a tela.";
                } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
                    msg = "movimentou a tela.";
                }

                msg += "X: " + event.getRawX() + " Y: " + event.getRawY();

                tvInfo.setText(msg);
                tela.addView(tvInfo);

                return true;
            }
        });
    }
}

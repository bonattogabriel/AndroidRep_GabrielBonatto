package br.edu.utfpr.usandotimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView tvRelogio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRelogio = findViewById(R.id.tvRelogio);
        Timer agendador = new Timer();
        agendador.scheduleAtFixedRate(new AtualizaHora(),0,1000);
    }

    class AtualizaHora extends TimerTask {
        public void run() {

            MainActivity.this.runOnUiThread(
                    new Thread(){
                    public void run() {
                Date agora = new Date();
                SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss");
                tvRelogio.setText(formatador.format(agora));
            }
            });

        }
    }
}

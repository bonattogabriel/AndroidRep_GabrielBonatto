package br.edu.utfpr.usandoprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbProgresso;
    private int aux = 0;
    private Button btIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbProgresso = findViewById(R.id.pbProgresso);
        btIniciar = findViewById(R.id.btIniciar);
    }

    public void btIniciarOnClick(View view) {
        btIniciar.setEnabled(false);
        new atualizaTelaThread().start();
    }

    class atualizaTelaThread extends Thread {
        public void run() {
            for(int i = 0; i <100; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                pbProgresso.setProgress(i);
            }
                MainActivity.this.runOnUiThread(new Thread() {
                    public void run() {
                        btIniciar.setEnabled(true);
                    }
                });
        }
    }
}

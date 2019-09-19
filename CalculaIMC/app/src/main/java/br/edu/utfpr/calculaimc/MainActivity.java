package br.edu.utfpr.calculaimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private Button btLimpar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso      = findViewById(R.id.etPeso);
        etAltura    = findViewById(R.id.etAltura);
        btCalcular  = findViewById(R.id.btCalcular);
        btLimpar    = findViewById(R.id.btLimpar);
        tvResultado = findViewById(R.id.tvResultado);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btCalcularOnClick();
            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                btLimparOnClick();
            }
        });

        btCalcular.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                btCalcularOnLongClick();
                return true;
            }
        });

        btLimpar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                btLimparOnLongClick();
                return true;
            }
        });
    }

    private void btLimparOnLongClick() {
        Toast.makeText(this, getString(R.string.limpa_long_click), Toast.LENGTH_LONG).show();
    }

    private void btCalcularOnLongClick() {
        Toast.makeText(this,getString(R.string.calcula_long_click),Toast.LENGTH_LONG).show();
    }

    private void btLimparOnClick() {
        etPeso.setText("");
        etAltura.setText("");
        tvResultado.setText(getString(R.string.zeros));
        etPeso.requestFocus();
    }

    private void btCalcularOnClick() {
        //entrada
        if(etPeso.getText().toString().equals("") && etAltura.getText().toString().equals("")) {
            etPeso.setError(getString(R.string.erro_peso));
            etAltura.setError(getString(R.string.erro_altura));
            return;
        }
        if(etPeso.getText().toString().equals("")) {
            etPeso.setError(getString(R.string.erro_peso));
            return;
        }
        if(etAltura.getText().toString().equals("")) {
            etAltura.setError(getString(R.string.erro_altura));
            return;
        }
        Double peso = Double.parseDouble(etPeso.getText().toString());
        Double altura = Double.parseDouble(etAltura.getText().toString());
        Double imc = 0.0;

        //processamento
        if(Locale.getDefault().getLanguage().equals("en")) {
            imc = (peso * 703) / Math.pow(altura,2);
        } else {
            imc = peso / Math.pow(altura, 2);
        }
        //saída
        DecimalFormat df = new DecimalFormat(".##");
        tvResultado.setText(String.valueOf(df.format(imc)));
    }
}
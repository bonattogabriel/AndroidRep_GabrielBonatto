package br.edu.utfpr.praticarevisao;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int TIPO_MOEDA = 1;
    private EditText etInputMoeda;
    private EditText etInputValor;
    private String aux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputMoeda = findViewById(R.id.etInputMoeda);
        etInputValor = findViewById(R.id.etInputValor);
    }

    public void btnHistoricoOnClick(View view) {
        Intent i = new Intent(this, HistoricoActivity.class);
        i.putExtra("historico", aux);
        startActivity(i);
    }

    public void btnConverterOnClick(View view) {
         if(etInputValor.getText().toString().equals("")) {
            etInputValor.setError("Campo de Preenchimento Obrigatório!");
        }if(etInputMoeda.getText().toString().equals("")) {
            etInputMoeda.setError("Campo de Preenchimento Obrigatório!");
        }
        verificaConversores();
         efetuaConversao();
    }

    public void btnPesquisarOnClick(View view) {
        Intent i = new Intent(this, MoedaActivity.class);
        startActivityForResult(i,TIPO_MOEDA);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == TIPO_MOEDA) {
            if(resultCode == 0) {
                if(data != null) {
                    int cod = data.getIntExtra("cod",0);
                    etInputMoeda.setText(String.valueOf(cod));
                }
            }
        }
    }
    private void verificaConversores() {
        if(Locale.getDefault().getLanguage().equals("pt") && etInputMoeda.getText().toString().equals("1")) {
            Toast.makeText(this,"Moedas (corrente e conversão) são iguais!", Toast.LENGTH_LONG).show();
            return;
        } else if(Locale.getDefault().getLanguage().equals("en") && etInputMoeda.getText().toString().equals("2")) {
            Toast.makeText(this,"'Currency' and 'Convert to' are the same!", Toast.LENGTH_LONG).show();
            return;
        } else if(Locale.getDefault().getLanguage().equals("es") && etInputMoeda.getText().toString().equals("3")) {
            Toast.makeText(this,"Monedas (corriente y conversión) son iguales!", Toast.LENGTH_LONG).show();
            return;
        }
    }
    private void efetuaConversao() {

        DecimalFormat df = new DecimalFormat("#.##");

        double valor = Double.parseDouble(etInputValor.getText().toString());
        double conversao = 0.0;

        AlertDialog.Builder resultado = new AlertDialog.Builder(this);
        resultado.setTitle("Resultado:");

        if(Locale.getDefault().getLanguage().equals("pt")) {

            double dolar = 0.31;
            double peso = 4.71;

            if(etInputMoeda.getText().toString().equals("2")) {
                conversao = valor * dolar;
                enviaHistorico(String.format(df.format(valor)),"REAIS",String.format(df.format(conversao)),"DOLARES");
                resultado.setMessage(String.valueOf("Real: R$ ") + df.format(valor) + "\nDólar: US$ " + df.format(conversao));
                resultado.setNeutralButton("Voltar",null);
                resultado.show();
            } else if(etInputMoeda.getText().toString().equals("3")) {
                conversao = valor * peso;

                resultado.setMessage(String.valueOf("Real: R$ ") + df.format(valor) + "\nPeso: $ " + df.format(conversao));
                resultado.setNeutralButton("Voltar",null);
                resultado.show();
            } else {
                return;
            }
        } else if(Locale.getDefault().getLanguage().equals("en")) {

            double real = 3.21;
            double peso = 15.14;

            if(etInputMoeda.getText().toString().equals("1")) {
                conversao = valor * real;

                resultado.setMessage(String.valueOf("Dólar: US$ ") + df.format(valor) + "\nReal: R$ " + df.format(conversao));
                resultado.setNeutralButton("Back",null);
                resultado.show();
            } else if(etInputMoeda.getText().toString().equals("3")) {
                conversao = valor * peso;

                resultado.setMessage(String.valueOf("Dólar: US$ ") + df.format(valor) + "\nPeso: $ " + df.format(conversao));
                resultado.setNeutralButton("Back",null);
                resultado.show();
            }
            else {
                return;
            }
        } else if(Locale.getDefault().getLanguage().equals("es")) {
            double dolar = 0.07;
            double real = 0.21;

            if(etInputMoeda.getText().toString().equals("1")) {
                conversao = valor * real;

                resultado.setMessage(String.valueOf("Peso: $ ") + df.format(valor) + "\nReal: R$ " + df.format(conversao));
                resultado.setNeutralButton("Volta",null);
                resultado.show();
            } else if(etInputMoeda.getText().toString().equals("2")) {
                conversao = valor * dolar;

                resultado.setMessage(String.valueOf("Peso: $ ") + df.format(valor) + "\nDólar: US$ " + df.format(conversao));
                resultado.setNeutralButton("Volta",null);
                resultado.show();
            } else {
                return;
            }
        }
    }
    private void enviaHistorico(String valor, String moedaCorrente, String moedaConvertida, String conversao) {
        aux += valor + " - " + moedaCorrente + " - " + moedaConvertida + " - " + conversao + "\n";
    }
}

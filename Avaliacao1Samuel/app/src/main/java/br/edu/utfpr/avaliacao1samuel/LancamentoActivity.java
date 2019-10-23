package br.edu.utfpr.avaliacao1samuel;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LancamentoActivity extends AppCompatActivity {

    String auxTipo = "";
    String auxAcDebito[] = new String[100];
    String auxAcCredito[] = new String[100];
    Double auxValorDebito = 0.0;
    Double auxValorCredito = 0.0;

    DecimalFormat df = new DecimalFormat(".##");

    private Spinner spTipoCobranca;
    private AutoCompleteTextView acDesc;
    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancamento);

        spTipoCobranca = findViewById(R.id.spTipoCobranca);
        acDesc = findViewById(R.id.acDesc);
        etValor = findViewById(R.id.etValor);

        if(spTipoCobranca.getSelectedItem().toString().equals("Débito")) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, auxAcDebito);
            acDesc.setAdapter(adapter);
            acDesc.setThreshold(3);
        } else {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, auxAcCredito);
            acDesc.setAdapter(adapter);
            acDesc.setThreshold(3);
        }
    }

    public void LancarControleOnClick(View view) {
        int x = 0;
        int y = 0;
        Intent i = getIntent();
        auxTipo += spTipoCobranca.getSelectedItem().toString() + "\n";
        String auxArray = acDesc.getText().toString();

        if(spTipoCobranca.getSelectedItem().toString().equals("Débito")) {

            auxAcDebito[x] += auxArray.toString();

            i.putExtra("listaDebito",auxAcDebito);
            setResult(3,i);

            auxValorDebito = Double.parseDouble(etValor.getText().toString());

            i.putExtra("valorDebito",auxValorDebito);
            setResult(0,i);

            x++;
        } else {
            auxAcCredito[y] += auxArray.toString();

            i.putExtra("listaCredito",auxAcCredito);
            setResult(4,i);

            auxValorCredito += Double.parseDouble(etValor.getText().toString());

            i.putExtra("valorCredito",auxValorCredito);
            setResult(1,i);

            y++;
        }

        Toast.makeText(this, "Enviado Com Sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}

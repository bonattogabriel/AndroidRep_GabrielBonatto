package br.edu.utfpr.calculaimc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class PrincipalActivity extends Activity {

    private EditText etAltura;
    private EditText etPeso;
    private TextView tvResultado;
    private Button btCalcular;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        etAltura = (EditText) findViewById( R.id.etAltura );
        etPeso = (EditText) findViewById( R.id.etPeso );
        tvResultado = (TextView) findViewById( R.id.tvResultado );
        btCalcular = (Button) findViewById( R.id.btCalcular );
        btLimpar = (Button) findViewById( R.id.btLimpar );

        /*btCalcular.setOnClickListener(new View.OnClickListener() {
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
        });*/

        btLimpar.setOnLongClickListener( new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText( PrincipalActivity.this, getString(R.string.clique_longo_limpar), Toast.LENGTH_LONG ).show();
                return false;
            }

        });
    }

    public void btLimparOnClick(View v) {
        etAltura.setText( "" );
        etPeso.setText( "" );
        tvResultado.setText( getString( R.string.zeros ) );

    }

    public void btCalcularOnClick( View v ) {

        if ( etPeso.getText().toString().equals( "" ) ) {
            etPeso.setError( getString( R.string.erro_peso ) );
            return;
        }

        if ( etAltura.getText().toString().equals( "" ) ) {
            etAltura.setError( getString(R.string.erro_altura) );
            return;
        }

        //entrada;
        double altura = Double.parseDouble(etAltura.getText().toString());
        double peso = Double.parseDouble(etPeso.getText().toString());

        System.out.println( "msg" );

        Log.w( "inclusao_cliente", "caiu aqui pq o reg é duplicado" );

        //processamento
        double resultado = 0;

        if (Locale.getDefault().getLanguage().equals( "en" ) ) {
            resultado = (peso * 703 ) / Math.pow( altura, 2 );
        } else {
            resultado = peso / Math.pow( altura, 2 );
        }



        //saída
        tvResultado.setText( new DecimalFormat( "0.00" ).format( resultado ) );

    }

} //fim da PrincipalActivity

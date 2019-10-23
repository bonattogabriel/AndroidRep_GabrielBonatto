package br.edu.utfpr.componentesavancados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbMasc;
    private RadioButton rbFem;
    private CheckBox cbEsporteTerrestre;
    private CheckBox cbEsporteAquatico;
    private DatePicker dpNasc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbMasc = findViewById(R.id.rbMasc);
        rbFem = findViewById(R.id.rbFem);

        cbEsporteTerrestre = findViewById(R.id.cbEsporteTerrestre);
        cbEsporteAquatico = findViewById(R.id.cbEsporteAquatico);

        dpNasc = findViewById(R.id.dpNasc);
    }

    public void btTestarComponenteOnClick(View view) {

        String msg;

        if(rbMasc.isChecked()) {
            msg = "Masculino\n";
        } else if(rbFem.isChecked()) {
            msg = "Feminino\n";
        } else {
            msg = "NA\n";
        }

        if(cbEsporteTerrestre.isChecked()) {
            msg += "Esporte Terrestre\n";
        }

        if(cbEsporteAquatico.isChecked()) {
            msg += "Esporte Aquatico\n";
        }

        String data = dpNasc.getDayOfMonth() + "/" + (dpNasc.getMonth() +1) + "/" + dpNasc.getYear();

        msg += data;

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

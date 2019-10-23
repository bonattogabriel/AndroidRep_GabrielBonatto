package br.edu.utfpr.avaliacao1samuel;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  private static final int retorno = 1;

  private Double valorCredito = 0.0;
  private Double valorDebito = 0.0;
  private String auxCredito[] = new String[100];
  private String auxDebito[] = new String[100];


  private Button btLancar;
  private Button btTotalReceber;
  private Button btTotalPagar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btLancar = findViewById(R.id.btLancar);
    btTotalPagar = findViewById(R.id.btTotalPagar);
    btTotalReceber = findViewById(R.id.btTotalReceber);
  }

  public void LancarOnClick(View view) {
    Intent i = new Intent(this,LancamentoActivity.class);
    i.putExtra("listaDebito",auxDebito);
    i.putExtra("listaCredito",auxCredito);
    startActivityForResult(i, retorno);
  }

  public void TotalPagarOnClick(View view) {
    AlertDialog.Builder alerta = new AlertDialog.Builder(this);
    alerta.setTitle("Total a Pagar: ");
    alerta.setMessage(String.valueOf(valorDebito));
    alerta.setNeutralButton("Fechar", null);
    alerta.show();
  }

  public void TotalReceberOnClick(View view) {
    AlertDialog.Builder alerta = new AlertDialog.Builder(this);
    alerta.setTitle("Total a Receber: ");
    alerta.setMessage(String.valueOf(valorCredito));
    alerta.setNeutralButton("Fechar", null);
    alerta.show();
  }

  protected void (int requestCode, int resultCode, @Nullable Intent data) {
    int x = 0;
    int y = 0;
    if(requestCode == retorno) {
      if(resultCode == 1) {
        if(data != null) {
          valorCredito += data.getDoubleExtra("valorCredito",0.0);
        }
      }else if(resultCode == 0) {
        if(data != null) {
          valorDebito += data.getDoubleExtra("valorDebito",0.0); }
      }else if(resultCode == 3) {
        auxDebito[x] += data.getCharArrayExtra("listaDebito");
        x++;
      }else if(resultCode == 4) {
        auxCredito[x] += data.getCharArrayExtra("listaCredito");
        y++;
      }
    }
  }
}

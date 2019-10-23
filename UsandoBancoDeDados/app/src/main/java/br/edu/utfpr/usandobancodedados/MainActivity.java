package br.edu.utfpr.usandobancodedados;


import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import br.edu.utfpr.usandobancodedados.entidade.Cadastro;
import br.edu.utfpr.usandobancodedados.model.DatabaseHandler;

public class MainActivity extends AppCompatActivity {

    private EditText etCod;
    private EditText etNome;
    private EditText etTelefone;

    private DatabaseHandler dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCod = findViewById( R.id.etCod );
        etNome = findViewById( R.id.etNome );
        etTelefone = findViewById( R.id.etTelefone );

        dao = new DatabaseHandler( this );

    }

    public void btIncluirOnClick(View view) {
        Cadastro  cad = new Cadastro();
        cad.setNome( etNome.getText().toString() );
        cad.setTelefone( etTelefone.getText().toString() );
        dao.incluir( cad );

        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show();
    }




    public void btAlterarOnClick(View view) {

        Cadastro cad = new Cadastro();
        cad.set_id( Integer.parseInt( etCod.getText().toString() ) );
        cad.setNome( etNome.getText().toString() );
        cad.setTelefone( etTelefone.getText().toString() );

        dao.alterar( cad );

        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show();
    }

    public void btExcluirOnClick(View view) {
        dao.excluir( Integer.parseInt( etCod.getText().toString() ) );

        Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show();
    }

    public void btPesquisarOnClick(View view) {
        /*int cod = Integer.parseInt( etCod.getText().toString() );

        Cursor registro = banco.query( "cadastro",
                null, "_id = " + cod, null, null,
            null, null );

        if ( registro.moveToNext() ) {
//          etNome.setText( registro.getString( registro.getColumnIndex( "nome" ) ) );
            etTelefone.setText( registro.getString( registro.getColumnIndex( "telefone" ) ) );
            Toast.makeText( this, "Sucesso!!!", Toast.LENGTH_LONG ).show();
        } else {
            Toast.makeText( this, "Registro nao encontrado!!!", Toast.LENGTH_LONG ).show();
        }*/

        final EditText etCodPesquisa = new EditText( this );

        AlertDialog.Builder alerta = new AlertDialog.Builder( this );
        alerta.setTitle( "Pesquisa por Cód" );
        alerta.setCancelable( false );
        alerta.setPositiveButton("Pesquisar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int cod = Integer.parseInt( etCodPesquisa.getText().toString() );

                Cadastro cad = dao.pesquisar( cod );

                if ( cad != null ) {
                    etNome.setText( cad.getNome() );
                    etTelefone.setText( cad.getTelefone() );
                    etCod.setText( String.valueOf( cod ) );
                } else {
                    Toast.makeText( MainActivity.this,
                            "Registro nao encontrado",
                            Toast.LENGTH_LONG ).show();
                }


            }
        });
        alerta.setView( etCodPesquisa );
        alerta.show();

    }

    public void btListarOnClick(View view) {
/*        Cursor registros = banco.query( "cadastro",
                null,
                null, null, null, null, null );

        String resposta = "";

        while ( registros.moveToNext() ) {
            resposta += registros.getString( registros.getColumnIndex( "nome" ) ) +
                    " - " +
                    registros.getString( registros.getColumnIndex( "telefone" ) ) +
            "\n";


        }

        Toast.makeText( this, resposta, Toast.LENGTH_LONG ).show();*/;

        Cursor registros = dao.listar();

        ListView lvRegistros = new ListView( this );
        SimpleCursorAdapter adapter = new SimpleCursorAdapter( this,
                android.R.layout.simple_list_item_2,
                registros, new String[] { "nome", "telefone"},
                new int[] { android.R.id.text1, android.R.id.text2 } );
        lvRegistros.setAdapter( adapter );

        AlertDialog.Builder alerta = new AlertDialog.Builder( this );
        alerta.setTitle( "Registros" );
        alerta.setView( lvRegistros );
        alerta.setCancelable( false );
        alerta.setNeutralButton( "Ok", null );
        alerta.show();

    }
}

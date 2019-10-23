package br.edu.utfpr.avaliacao2revisao.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.utfpr.avaliacao2revisao.entidade.Disciplina;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String nome = "bd";
    private static int VERSION = 2;
    private static final String TABLE_NAME = "disciplina";

    public DatabaseHandler(Context c) {
        super(c, nome, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, disciplina TEXT, nota REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public void incluir(Disciplina disciplina) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues reg = new ContentValues();
        reg.put("disciplina", disciplina.getDisciplina());
        reg.put("nota", disciplina.getNota());
        bd.insert(TABLE_NAME, null, reg);
    }

    public void alterar(Disciplina disciplina) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues reg = new ContentValues();
        reg.put("disciplina",disciplina.getDisciplina());
        reg.put("nota",disciplina.getNota());
        bd.update(TABLE_NAME, reg, "_id = " + disciplina.get_id(), null);
    }

    public void excluir(int cod) {
        SQLiteDatabase bd = this.getWritableDatabase();
        bd.delete(TABLE_NAME,"_id = " + cod, null);
    }

    public String[] getDisciplinas() {
        SQLiteDatabase bd = this.getWritableDatabase();
        Cursor c = bd.query( "disciplina", new String[] {"disciplina"}, null, null, null, null, null );

        String registros[] = new String[ c.getCount() ];

        int i = 0;
        while ( c.moveToNext() ) {
            String nome = c.getString( c.getColumnIndex( "disciplina" ) );
            registros[i] = nome;
            i++;
        }

        return registros;
    }
}

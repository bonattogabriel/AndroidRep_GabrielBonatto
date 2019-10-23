package br.edu.utfpr.usandobancodedados.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.utfpr.usandobancodedados.entidade.Cadastro;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bd";
    private static int VERSION = 1;
    private static final String TABLE_NAME = "cadastro";

    public DatabaseHandler(Context c) {
        super(c, DATABASE_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS TABLE_NAME" +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    public void incluir(Cadastro cad) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues reg = new ContentValues();
        reg.put("nome",cad.getNome());
        reg.put("telefone",cad.getTelefone());
        bd.insert(TABLE_NAME, null, reg);
    }

    public void alterar(Cadastro cad) {
        SQLiteDatabase bd = this.getWritableDatabase();

        ContentValues reg = new ContentValues();
        reg.put("nome",cad.getNome());
        reg.put("telefone",cad.getTelefone());
        bd.update(TABLE_NAME, reg, "_id = " + cad.get_id(), null);
    }

    public void excluir(int cod) {
        SQLiteDatabase bd = this.getWritableDatabase();

        bd.delete(TABLE_NAME,"_id = " + cod, null);
    }

    public Cadastro pesquisar(int cod) {
        SQLiteDatabase bd = this.getWritableDatabase();

        Cursor reg = bd.query(TABLE_NAME,null,"_id = " + cod,
                null,null,null,null);

        if(reg.moveToNext()) {
            Cadastro cad = new Cadastro();
            cad.set_id(cod);
            cad.setNome(reg.getString(reg.getColumnIndex("nome")));
            cad.setTelefone(reg.getString(reg.getColumnIndex("telefone")));

            return cad;
        } else {
            return null;
        }
    }

    public Cursor listar() {
        SQLiteDatabase bd = this.getWritableDatabase();

        Cursor regs = bd.query(TABLE_NAME,null,null,
                null,null,null,null);

        return regs;
    }


}

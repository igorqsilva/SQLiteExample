package com.example.lucas.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lucas on 16-May-17.
 */

public class Banco extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";

    private static final String CLIENTES = "bd_clientes";
    private static final String CODIGO = "bd_codigo";
    private static final String NOME = "bd_nome";
    private static final String TELEFONE = "bd_telefone";
    private static final String EMAIL = "bd_email";


    public Banco(Context context) {
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY = "CREATE TABLE " + CLIENTES + "("
                + CODIGO + " INTEGER PRIMARY KEY, "
                + NOME + " TEXT, "
                + TELEFONE + " TEXT, "
                + EMAIL + " TEXT)";

        db.execSQL(QUERY);
    }

    void addCliente (Cliente cliente){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, cliente.getNome());
        values.put(TELEFONE, cliente.getTelefone());
        values.put(EMAIL,cliente.getEmail());

        db.insert(CLIENTES,null,values);

        db.close();


    }

    void apagarCliente(Cliente cliente){


        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(CLIENTES,CODIGO + " = ?", new String[] {String.valueOf(cliente.getCodigo())});


    }

    Cliente selecionarCliente(int codigo){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(CLIENTES, new String[]{CODIGO,NOME,TELEFONE,EMAIL},
                                CODIGO + " = ?", new String[]{String.valueOf(codigo)},
                                null,null,null,null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        Cliente cliente = new Cliente(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getString(3));

        return cliente;
    }
    void atualizarCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOME, cliente.getNome());
        values.put(TELEFONE, cliente.getTelefone());
        values.put(EMAIL,cliente.getEmail());

        db.update(CLIENTES, values, CODIGO + " =  ?",
                new String[]{String.valueOf(cliente.getCodigo())});

    }





        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

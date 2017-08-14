package com.joaodamorim.interceptors.usuario.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    protected static final String NOME_DB = "banco.db";
    protected static final int VERSAO = 1;
    private SqlScripts scripts = new SqlScripts();

    // TABELA DOS USUARIOS
    protected static final String TABELA_USUARIO = "tabela_usuarios";
    protected static final String ID_USER = "_id_usuario";
    protected static final String USER = "user";
    protected static final String PASSWORD = "password";

    // TABELA DAS PESSOAS
    protected static final String TABELA_PESSOA = "tabela_pessoas";
    protected static final String ID_PESSOA = "_id_pessoa";
    protected static final String NOME = "nome";
    protected static final String PESSOA_USER = "pessoa_usuario";

    // TABELA DAS ESPECIES
    protected static final String TABELA_ESPECIE = "tabela_especies";
    protected static final String ID_ESPECIE = "_id_especie";
    protected static final String NOME_ESPECIE = "nome_especie";
    protected static final String QUANTIDADE_ESPECIE = "quant_especie";
    protected static final String LOCAL_ESPECIE = "local_especie";


    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scripts.createTabelaUsuario());
        db.execSQL(scripts.createTabelaPessoa());
        db.execSQL(scripts.createTabelaEspecie());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ESPECIE);

        onCreate(db);
    }
}

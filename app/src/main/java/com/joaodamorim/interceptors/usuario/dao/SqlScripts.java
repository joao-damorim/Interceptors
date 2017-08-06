package com.joaodamorim.interceptors.usuario.dao;

import static com.joaodamorim.interceptors.usuario.dao.DbHelper.*;

public class SqlScripts {
    protected String createTabelaUsuario(){

        StringBuilder userBuilder = new StringBuilder();
        userBuilder.append("CREATE TABLE "+ TABELA_USUARIO +" ( ");
        userBuilder.append(ID_USER +" integer primary key autoincrement, ");
        userBuilder.append(USER+" text not null unique, ");
        userBuilder.append(PASSWORD+" text not null);");
        return userBuilder.toString();
    }
    protected String createTabelaPessoa() {

        StringBuilder pessoaBuilder = new StringBuilder();
        pessoaBuilder.append("CREATE TABLE " + TABELA_PESSOA + " ( ");
        pessoaBuilder.append(ID_PESSOA + " integer primary key autoincrement, ");
        pessoaBuilder.append(NOME + " text not null, ");
        pessoaBuilder.append(PESSOA_USER + " text not null unique);");
        return pessoaBuilder.toString();
    }
    protected String cmdWhere(String tabela, String a, String b){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ? AND " + b + " LIKE ?";
    }
    protected String cmdWhere(String tabela, String a){
        return "SELECT * FROM " + tabela + " WHERE " + a + " LIKE ?";
    }
    protected String cmdWhereValues(String tabela, String coluna, String valor){
        return "SELECT * FROM" + tabela +" WHERE " + coluna + " LIKE " + valor;
    }
}
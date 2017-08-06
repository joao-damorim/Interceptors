package com.joaodamorim.interceptors.usuario.negocio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.joaodamorim.interceptors.usuario.dao.UsuarioDao;
import com.joaodamorim.interceptors.usuario.dominio.Pessoa;
import com.joaodamorim.interceptors.usuario.gui.LogInActivity;


public class SessaoUsuario {
    private Pessoa usuarioLogado;
    private SharedPreferences preferences;
    private Context context;
    private SharedPreferences.Editor editor;
    private static final String USUARIO_LOGADO = "Logado";
    private static final String NOME_USUARIO = "nome";
    private static final String PREFER_NOME = "preferencia";


    public SessaoUsuario(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFER_NOME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void iniciarSessao(Context context){
        UsuarioDao dao = new UsuarioDao(context);
        String usuario = getNome();

        setUsuarioLogado(dao.buscarPessoa(usuario));
    }

    public void logarUsuario(String nome) {
        editor.putBoolean(USUARIO_LOGADO, true);
        editor.putString(NOME_USUARIO, nome);
        editor.apply();
    }

    public void encerrarSessao() {
        editor.clear();
        editor.apply();

        //Intent intent = new Intent(context, LogInActivity.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //context.startActivity(intent);
    }

    public boolean verificarLogin() {
        if (!this.vericarSesssao()){
            Intent intent = new Intent(context, LogInActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

            return true;
        }
        return false;
    }

    public Pessoa getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Pessoa usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    public String getNome() {
        return preferences.getString(NOME_USUARIO, null);
    }
    private boolean vericarSesssao() {
        return preferences.getBoolean(USUARIO_LOGADO, false);
    }
}
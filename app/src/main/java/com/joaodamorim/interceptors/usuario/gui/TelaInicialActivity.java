package com.joaodamorim.interceptors.usuario.gui;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.joaodamorim.interceptors.R;
import com.joaodamorim.interceptors.usuario.negocio.SessaoUsuario;

public class TelaInicialActivity extends AppCompatActivity {

        private SharedPreferences preferences;
        private SessaoUsuario sessao;
        private TextView boasVindas;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tela_inicial);
            bemVindo();
        }
    public void bemVindo(){
        preferences = getSharedPreferences("user", Context.MODE_APPEND);
        sessao = new SessaoUsuario(getApplicationContext());

        if (sessao.verificarLogin()){
            finish();
        }

        boasVindas = (TextView)findViewById(R.id.boasVindas);
        String bemvindo = boasVindas.getText().toString() +  sessao.getNome() + ".";
        boasVindas.setText(bemvindo);
    }
}

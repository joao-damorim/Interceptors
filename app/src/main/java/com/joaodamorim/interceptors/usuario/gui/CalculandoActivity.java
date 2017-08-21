package com.joaodamorim.interceptors.usuario.gui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.joaodamorim.interceptors.R;
import com.joaodamorim.interceptors.usuario.negocio.MinhaTask;

import java.util.ArrayList;

public class CalculandoActivity extends AppCompatActivity {
    private ArrayList<String> listaEspecie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculando);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        TextView texto = (TextView) findViewById(R.id.texto);

        new MinhaTask(this, progress, texto).execute();
        listaEspecie = getIntent().getStringArrayListExtra("lista");
    }

    public void acessarRelatorio (View view) throws Exception{

        Intent i = new Intent(CalculandoActivity.this, RelatorioActivity.class);
        i.putExtra("lista", listaEspecie);
        startActivity(i);
    }
}

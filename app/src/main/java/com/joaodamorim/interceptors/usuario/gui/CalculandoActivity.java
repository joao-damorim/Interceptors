package com.joaodamorim.interceptors.usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.joaodamorim.interceptors.R;
import com.joaodamorim.interceptors.usuario.negocio.MinhaTask;

public class CalculandoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculando);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progress);
        TextView texto = (TextView) findViewById(R.id.texto);

        new MinhaTask(this, progress, texto).execute();
    }
}

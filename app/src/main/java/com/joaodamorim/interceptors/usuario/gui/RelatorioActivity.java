package com.joaodamorim.interceptors.usuario.gui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.joaodamorim.interceptors.R;

import java.util.ArrayList;
import java.util.LinkedList;

public class RelatorioActivity extends AppCompatActivity {
    private ArrayList<String> listaEspecie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        listaEspecie = getIntent().getStringArrayListExtra("lista");

        ListView lista = (ListView) findViewById(R.id.lvRelatorio);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaEspecie);
        lista.setAdapter(arrayAdapter);
    }
}

package com.joaodamorim.interceptors.usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.joaodamorim.interceptors.R;

public class EspecieActivity extends AppCompatActivity {
    private EditText et_nome_especie;
    private EditText et_quant_especie;
    private EditText et_local_especie;

    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especie);

        et_nome_especie = (EditText) findViewById (R.id.et_nome_especie);
        et_quant_especie = (EditText) findViewById (R.id.et_quant_especie);
        et_local_especie = (EditText) findViewById (R.id.et_local_especie);

        initViews();

    }
    public void initViews() {
        resources = getResources();
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        et_nome_especie.addTextChangedListener(textWatcher);
        et_quant_especie.addTextChangedListener(textWatcher);
        et_local_especie.addTextChangedListener(textWatcher);

    }
    public void calcularEspecie (View view) throws Exception{
        Intent i = new Intent(EspecieActivity.this, CalculandoActivity.class);
        startActivity(i);

    }

}

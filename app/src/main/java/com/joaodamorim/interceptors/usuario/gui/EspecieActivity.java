package com.joaodamorim.interceptors.usuario.gui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.joaodamorim.interceptors.R;
import com.joaodamorim.interceptors.usuario.negocio.EspecieNegocio;

import java.util.ArrayList;
import java.util.LinkedList;


public class EspecieActivity extends AppCompatActivity {
    private EditText etNomeEspecie;
    private EditText etQuantEspecie;
    private EditText etLocalEspecie;
    private ArrayList<String> listaRelatorio;
    private EspecieNegocio especieNegocio;

    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especie);

        etNomeEspecie = (EditText) findViewById(R.id.et_nome_especie);
        etQuantEspecie = (EditText) findViewById(R.id.et_quant_especie);
        etLocalEspecie = (EditText) findViewById(R.id.et_local_especie);

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

        etNomeEspecie.addTextChangedListener(textWatcher);
        etQuantEspecie.addTextChangedListener(textWatcher);
        etLocalEspecie.addTextChangedListener(textWatcher);

    }

    public void calcularImpacto(View view) throws Exception {
        boolean validar = validarCampos();
        if (validar) {
            especieNegocio = new EspecieNegocio();
            listaRelatorio = new ArrayList<String>();
            listaRelatorio.add("*** Nome da Espécie ***");
            listaRelatorio.add(etNomeEspecie.getText().toString());
            listaRelatorio.add("*** Quantidade avistada ***");
            listaRelatorio.add(etQuantEspecie.getText().toString());
            listaRelatorio.add("*** Taxa de Cresimento ao ano de acordo com a quantidade avistada ***");
            listaRelatorio.add(especieNegocio.quantEspecieCalculo(etQuantEspecie.getText().toString()));
            listaRelatorio.add("*** Danos esperados ***");
            listaRelatorio.add(especieNegocio.danosEspecie(etNomeEspecie.getText().toString()));
            listaRelatorio.add("*** Local do Avistamento ***");
            listaRelatorio.add(etLocalEspecie.getText().toString());

            Intent i = new Intent(EspecieActivity.this, CalculandoActivity.class);
            i.putExtra("lista",listaRelatorio);
            startActivity(i);
        }
    }

    public boolean validarCampos() {
        String nomeEspecie = etNomeEspecie.getText().toString();
        String quantEspecie = etQuantEspecie.getText().toString();
        String localEspecie = etLocalEspecie.getText().toString();

        if (isCamposValidos(nomeEspecie, quantEspecie, localEspecie)) {
            return true;
        }
        return false;
    }

    public boolean isCamposValidos(String nomeEspecie, String quantEspecie, String localEspecie) {
        boolean verificador = false;
        if (TextUtils.isEmpty(nomeEspecie)) {
            etNomeEspecie.requestFocus();
            etNomeEspecie.setError(resources.getString(R.string.erro_espaco_branco));
        } else if (TextUtils.isEmpty(quantEspecie)) {
            etQuantEspecie.requestFocus();
            etQuantEspecie.setError(resources.getString(R.string.erro_espaco_branco));
        } else if (TextUtils.isEmpty(localEspecie)) {
            etLocalEspecie.requestFocus();
            etLocalEspecie.setError(resources.getString(R.string.erro_espaco_branco));
        } else {
            verificador = true;
        }
        return verificador;
    }
}

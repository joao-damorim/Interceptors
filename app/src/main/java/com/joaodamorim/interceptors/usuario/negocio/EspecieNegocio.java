package com.joaodamorim.interceptors.usuario.negocio;

public class EspecieNegocio {

    public String quantEspecieCalculo(String quantEspecie){
        double formula = (((200 - Integer.parseInt(quantEspecie)) / Integer.parseInt(quantEspecie)) * 100);
        String resultado = String.format("%.2f%%", formula);
        return resultado;
    }
    public String danosEspecie(String nomeEspecie){
        String danos = null;
        if (nomeEspecie.equals("caramujo") || nomeEspecie.equals("Caramujo")){
            danos = "O Caramujo é uma das piores pestes das regiões tropicais e subtropicais, rasteja por 23 estados brasileiros. Ataca plantações e prejudica a economia.";
        }
        return danos;
    }
}

package com.joaodamorim.interceptors.usuario.negocio;

/**
 * Created by Joao on 01/08/2017.
 */

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaSenha {
    public String criptoSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaCriptografada = hexString.toString();
        return senhaCriptografada;
    }
}

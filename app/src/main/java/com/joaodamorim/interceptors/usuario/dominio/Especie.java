package com.joaodamorim.interceptors.usuario.dominio;

public class Especie {
    private int id;
    private String nome;
    private int quantidade;
    private String local;

    public Especie(){
        this.nome = null;
        this.quantidade = Integer.parseInt(null);
        this.local = null;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getLocal(){
        return local;
    }

    public void setLocal(String local){
        this.local = local;
    }
}


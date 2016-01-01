package com.example.andr.androidgamesreview;

/**
 * Created by amand on 31/12/2015.
 */
public class Produtora {

    int _cod_produtora;
    String _nome_produtora;


    public Produtora(){

    }

    public Produtora(String nome_produtora){
        this._nome_produtora = nome_produtora;
    }

    public Produtora (int cod_produtora, String nome_produtora){
        this._cod_produtora = cod_produtora;
        this._nome_produtora = nome_produtora;
    }

    public int get_cod_produtora() {
        return _cod_produtora;
    }

    public String get_nome_produtora() {
        return _nome_produtora;
    }

    public void set_cod_produtora(int _cod_produtora) {
        this._cod_produtora = _cod_produtora;
    }

    public void set_nome_produtora(String _nome_produtora) {
        this._nome_produtora = _nome_produtora;
    }
}

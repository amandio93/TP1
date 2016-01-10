package com.example.andr.androidgamesreview.Model;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: Categoria
 * Data entrega: 22/01/2016
 */
public class Categoria {

    int _cod_categoria;
    String _nome_categoria;

    public Categoria(){
    }

    public Categoria(String nome_categoria){
        this._nome_categoria = nome_categoria;
    }

    public Categoria (int cod_categoria, String nome_categoria){
        this._cod_categoria = cod_categoria;
        this._nome_categoria = nome_categoria;
    }

    public int get_cod_categoria() {
        return this._cod_categoria;
    }

    public String get_nome_categoria() {
        return this._nome_categoria;
    }

    public void set_cod_categoria(int cod_categoria) {
        this._cod_categoria = cod_categoria;
    }

    public void set_nome_categoria(String nome_categoria) {
        this._nome_categoria = nome_categoria;
    }
}

package com.example.andr.androidgamesreview;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Created by amand on 31/12/2015.
 */
public class Jogo {

    int _cod_jogo;
    String _nome_jogo;
    String _descricao_jogo;
    double _classificacao_jogo;
    String _nome_imagem_jogo;
    String _link_video_jogo;
    String _cod_produtora;
    String _cod_categoria;

    public Jogo(){
    }

    public Jogo(String nome_jogo, String descricao_jogo, double classificacao_jogo,
                String nome_imagem_jogo, String link_video_jogo, String cod_produtora, String cod_categoria){

        this._nome_jogo = nome_jogo;
        this._descricao_jogo = descricao_jogo;
        this._classificacao_jogo = classificacao_jogo;
        this._nome_imagem_jogo = nome_imagem_jogo;
        this._link_video_jogo = link_video_jogo;
        this._cod_produtora = cod_produtora;
        this._cod_categoria = cod_categoria;

    }

    public Jogo(int cod_jogo, String nome_jogo, String descricao_jogo, double classificacao_jogo,
                    String nome_imagem_jogo, String link_video_jogo, String cod_produtora, String cod_categoria){

        this._cod_jogo = cod_jogo;
        this._nome_jogo = nome_jogo;
        this._descricao_jogo = descricao_jogo;
        this._classificacao_jogo = classificacao_jogo;
        this._nome_imagem_jogo = nome_imagem_jogo;
        this._link_video_jogo = link_video_jogo;
        this._cod_produtora = cod_produtora;
        this._cod_categoria = cod_categoria;

    }

    public int get_cod_jogo() {
        return _cod_jogo;
    }

    public String get_nome_jogo() {
        return _nome_jogo;
    }

    public String get_descricao_jogo() {
        return _descricao_jogo;
    }

    public double get_classificacao_jogo() {
        return _classificacao_jogo;
    }

    public String get_nome_imagem_jogo() {
        return _nome_imagem_jogo;
    }

    public String get_link_video_jogo() {
        return _link_video_jogo;
    }

    public String get_cod_produtora() {
        return _cod_produtora;
    }

    public String get_cod_categoria() {
        return _cod_categoria;
    }

    public void set_cod_jogo(int _cod_jogo) {
        this._cod_jogo = _cod_jogo;
    }

    public void set_nome_jogo(String _nome_jogo) {
        this._nome_jogo = _nome_jogo;
    }

    public void set_descricao_jogo(String _descricao_jogo) {
        this._descricao_jogo = _descricao_jogo;
    }

    public void set_classificacao_jogo(double _classificacao_jogo) {
        this._classificacao_jogo = _classificacao_jogo;
    }

    public void set_nome_imagem_jogo(String _nome_imagem_jogo) {
        this._nome_imagem_jogo = _nome_imagem_jogo;
    }

    public void set_link_video_jogo(String _link_video_jogo) {
        this._link_video_jogo = _link_video_jogo;
    }

    public void set_cod_produtora(String _cod_produtora) {
        this._cod_produtora = _cod_produtora;
    }

    public void set_cod_categoria(String _cod_categoria) {
        this._cod_categoria = _cod_categoria;
    }
}

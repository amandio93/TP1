package com.example.andr.androidgamesreview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameInfo extends Fragment {

    static String ARG_POSITION = "position";
    public TextView txtNomeJogo;
    public TextView txtClassificacao;
    public TextView txtCategoria;
    public TextView txtProdutora;

    public String nomeJogo;
    public String classificacaoJogo;
    public String produtoraJogo;
    public String categoriaJogo;

    public GameInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        Bundle args = getArguments();
        Integer argsInt = args.getInt(ARG_POSITION);
        Log.d("Arg Position", argsInt.toString());

        txtNomeJogo = (TextView)view.findViewById(R.id.txtNomeJogo);
        txtClassificacao = (TextView)view.findViewById(R.id.txtClassificacao);
        txtCategoria = (TextView)view.findViewById(R.id.txtCategoria);
        txtProdutora = (TextView)view.findViewById(R.id.txtProdutora);

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> jogos = db.getAllJogos(ARG_POSITION);

        for (Jogo cn : jogos) {
            String log = "Id: "+cn.get_nome_jogo()+" ,Name: " + cn.get_classificacao_jogo();
            Log.d("Name: ", log);
            nomeJogo = cn.get_nome_jogo();
            classificacaoJogo = String.valueOf(cn.get_classificacao_jogo());
            categoriaJogo = cn.get_cod_categoria();
            produtoraJogo = cn.get_cod_produtora();
        }

        txtNomeJogo.setText(nomeJogo);
        txtClassificacao.setText(classificacaoJogo);
        txtCategoria.setText(categoriaJogo);
        txtProdutora.setText(produtoraJogo);

        return view;
    }

}

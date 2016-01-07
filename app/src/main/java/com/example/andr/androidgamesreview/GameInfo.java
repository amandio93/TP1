package com.example.andr.androidgamesreview;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    public TextView txtDescricao;
    public ImageView imgVjogo;
    public Button btnVideo;

    public String nomeJogo;
    public String classificacaoJogo;
    public String produtoraJogo;
    public String categoriaJogo;
    public String descricao;
    public String nomeImagem;
    public String linkVideo;


    public GameInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        /*Bundle args = getArguments();
        Integer argsInt = args.getInt(ARG_POSITION);
        GameInfo gI = new GameInfo();
        gI.setArguments(args);
        String x = gI.getArguments().toString();*/

        String x = "";
        if (getArguments() != null) {
            Integer pos = Integer.valueOf(getArguments().getString(ARG_POSITION)) + 1;
            x = String.valueOf(pos);
        }


       // Log.d("Arg Position", argsInt.toString());

        txtNomeJogo = (TextView)view.findViewById(R.id.txtNomeJogo);
        txtClassificacao = (TextView)view.findViewById(R.id.txtClassificacao);
        txtCategoria = (TextView)view.findViewById(R.id.txtCategoria);
        txtProdutora = (TextView)view.findViewById(R.id.txtProdutora);
        txtDescricao = (TextView)view.findViewById(R.id.txtDescricao);
        imgVjogo = (ImageView)view.findViewById(R.id.imageView);
        btnVideo = (Button)view.findViewById(R.id.btnVideo);


        /*argsInt = argsInt +1;
        String id = argsInt.toString();*/

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> jogos = db.getAllJogos(x);

        for (Jogo cn : jogos) {
            String log = "Id: "+cn.get_nome_jogo()+" ,Name: " + cn.get_classificacao_jogo();
            Log.d("Name: ", log);
            nomeJogo = cn.get_nome_jogo();
            classificacaoJogo = String.valueOf(cn.get_classificacao_jogo());
            categoriaJogo = cn.get_cod_categoria();
            produtoraJogo = cn.get_cod_produtora();
            descricao = cn.get_descricao_jogo();
            nomeImagem = cn.get_nome_imagem_jogo();
            linkVideo = cn.get_link_video_jogo();
        }

        txtNomeJogo.setText(nomeJogo);
        txtClassificacao.setText(classificacaoJogo);
        txtCategoria.setText(categoriaJogo);
        txtProdutora.setText(produtoraJogo);
        txtDescricao.setText("Descrição: \n" + descricao);


        String uri = "@drawable/" + nomeImagem;
        try{
        int imageResource = getResources().getIdentifier(uri, null, getContext().getPackageName());
        Drawable res = getResources().getDrawable(imageResource);
        imgVjogo.setImageDrawable(res);}
        catch (Exception ex){
            String notFound = "@drawable/notfound";
            int imageResourceNotFound = getResources().getIdentifier(notFound, null, getContext().getPackageName());
            Drawable res2 = getResources().getDrawable(imageResourceNotFound);
            imgVjogo.setImageDrawable(res2);
        }


        btnVideo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkVideo)));
                } catch (Exception ex) {
                    Toast.makeText(getContext(), "Não foi possível ver o video!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }

}

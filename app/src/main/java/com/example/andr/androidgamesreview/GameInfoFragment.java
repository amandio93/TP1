package com.example.andr.androidgamesreview;


import android.content.Intent;
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

import com.example.andr.androidgamesreview.Model.DatabaseHandler;
import com.example.andr.androidgamesreview.Model.Jogo;

import java.util.List;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: GameInfoFragment
 * Data entrega: 22/01/2016
 */
public class GameInfoFragment extends Fragment {

    static String ARG_POSITION = "position";
    public TextView txtNomeJogo;
    public TextView txtClassificacao;
    public TextView txtCategoria;
    public TextView txtProdutora;
    public TextView txtDescricao;
    public ImageView imgVjogo;
    public Button btnVideo;
    public Button btnStore;

    public String nomeJogo;
    public String classificacaoJogo;
    public String produtoraJogo;
    public String categoriaJogo;
    public String descricao;
    public String nomeImagem;
    public String linkVideo;
    public String linkStore;


    public GameInfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_info, container, false);

        String x = "";
        if (getArguments() != null) {
            Integer pos = Integer.valueOf(getArguments().getString(ARG_POSITION)) + 1;
            x = String.valueOf(pos);
        }

        txtNomeJogo = (TextView)view.findViewById(R.id.txtNomeJogo);
        txtClassificacao = (TextView)view.findViewById(R.id.txtClassificacao);
        txtCategoria = (TextView)view.findViewById(R.id.txtCategoria);
        txtProdutora = (TextView)view.findViewById(R.id.txtProdutora);
        txtDescricao = (TextView)view.findViewById(R.id.txtDescricao);
        imgVjogo = (ImageView)view.findViewById(R.id.imageView);
        btnVideo = (Button)view.findViewById(R.id.btnVideo);
        btnStore = (Button)view.findViewById(R.id.btnGooglePlay);

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
            linkStore = cn.get_link_store_jogo();
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

        btnStore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(linkStore)));
                } catch (Exception ex) {
                    Toast.makeText(getContext(), "Não foi possível aceder ao jogo na Google Play Store!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}

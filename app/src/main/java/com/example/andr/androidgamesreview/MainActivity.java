package com.example.andr.androidgamesreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Button btnGameList = (Button) findViewById(R.id.btnGameList);
        Button btnCategoria = (Button) findViewById(R.id.btnCategoria);
        Button btnProdutora = (Button) findViewById(R.id.btnProdutora);
        btnGameList.setOnClickListener(myOnlyhandler);
        btnCategoria.setOnClickListener(myOnlyhandler);
        btnProdutora.setOnClickListener(myOnlyhandler);*/

        DatabaseHandler db = new DatabaseHandler(this);
        List<Categoria> categorias = db.getAllCategorias();
        List<Produtora> produtoras = db.getAllProdutoras();
        List<Jogo> jogos = db.getAllJogos();

        if (categorias.size() == 0){
            insert_Dados();
        } else if (produtoras.size() == 0){
            insert_Dados();
        } else if(jogos.size() == 0){
            insert_Dados();
        }

    }

    /*View.OnClickListener myOnlyhandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnGameList:
                    buttonName = "gameList";
                    break;
                case R.id.btnCategoria:
                    buttonName = "categoria";
                    break;
                case R.id.btnProdutora:
                    buttonName = "produtora";
                    break;
            }
        }
    };*/

    public void btnGameList_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentLocal.class);
        fragmentLocal.putExtra("btnName", "gameList");
        startActivity(fragmentLocal);
    }

    public void btnCategoria_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentLocal.class);
        fragmentLocal.putExtra("btnName", "categoria");
        startActivity(fragmentLocal);
    }

    public void btnProdutora_OnClick(View view){
        Intent fragmentLocal = new Intent(this, FragmentLocal.class);
        fragmentLocal.putExtra("btnName", "produtora");
        startActivity(fragmentLocal);
    }

    public void insert_Dados(){
        DatabaseHandler db = new DatabaseHandler(this);
        db.addCategoria(new Categoria("FPS"));
        db.addCategoria(new Categoria("MMO"));
        db.addCategoria(new Categoria("Acção"));

        db.addProdutora(new Produtora("Jogos SA"));
        db.addProdutora(new Produtora("Android SA"));
        db.addProdutora(new Produtora("Games LDA"));

        db.addJogo(new Jogo("Tiro ao alvo", "Isto é um jogo de tiro ao alvo", 3.9, "tiro.jpg", "www.youtube.com", "1", "1"));
        db.addJogo(new Jogo("WoW", "Isto é um jogo de WOW", 5, "wow.jpg", "www.youtube.com", "3", "2"));
        db.addJogo(new Jogo("ActionMan", "Isto é um jogo de Accção", 2, "actionman.jpg", "www.youtube.com", "3", "3"));
    }


}

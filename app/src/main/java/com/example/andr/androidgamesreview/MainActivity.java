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
        db.addCategoria(new Categoria("Arcada"));
        db.addCategoria(new Categoria("Cartas"));
        db.addCategoria(new Categoria("Desporto"));

        db.addProdutora(new Produtora("Clean Master Games"));
        db.addProdutora(new Produtora("TaoGames Limited"));
        db.addProdutora(new Produtora("First Touch"));
        db.addProdutora(new Produtora("Kiloo"));
        db.addProdutora(new Produtora("Miniclip.com"));

        db.addJogo(new Jogo("Piano Tiles", "Piano Tiles 2 é a sequência do Piano Tiles (Don't Tap the White Tile), " +
                "que é mundialmente conhecido e popular. " +
                "Nova jogabilidade, a qualidade de som de primeira e o modo de competição " +
                "global lhe trará a emoção ao controlar o dedo e prazer de tocar piano.", 4.7, "pianotiles", "https://youtu.be/kkvSM-0vxHg", "1", "1"));

        db.addJogo(new Jogo("Solitário", "Jogue o #1 jogo de cartas Solitário (ou Solitário Klondike / Paciência) no Android!\n" +
                "Solitário Clássico, também conhecido como Paciência, é o jogo de cartas mais popular do mundo. " +
                "Experimente o nosso app de cartas, o MELHOR SOLITÁRIO GRÁTIS," +
                " que é bonito e divertido como o Solitário clássico do Windows.", 4.7, "solitario", "", "2", "2"));

        db.addJogo(new Jogo("Score! Hero", "Score! Hero, dos premiados criadores de Score! World Goals, Dream League Soccer e First Touch Soccer.\n" +
                "SEJA UM HERÓI! Passe, chute e marque seu caminho até um status de lenda, enquanto explora a dramática " +
                "carreira do seu HERÓI por 320 níveis desafiadores!", 4.7, "scorehero", "https://youtu.be/M5XXJ_rNzNc", "3", "3"));

        db.addJogo(new Jogo("Subway Surfers", "DASH as fast as you can! \n" +
                "DODGE the oncoming trains!\n" +
                "Help Jake, Tricky & Fresh escape from the grumpy Inspector and his dog.", 4.4, "subwaysurfers", "https://youtu.be/fUk_eBKL3q8", "4", "1"));

        db.addJogo(new Jogo("8 Ball Pool", "O jogo de bilhar nº 1 do mundo - agora para Android!•\n" +
                "Joga com amigos! Joga com lendas. Joga o famoso jogo 8 Ball Pool da Miniclip no " +
                "teu dispositivo móvel e torna-te o melhor!", 4.5, "eightballpool", "https://youtu.be/MarGQrmbPm0", "5", "3"));

    }


}

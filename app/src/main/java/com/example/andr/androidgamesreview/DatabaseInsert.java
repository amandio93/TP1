package com.example.andr.androidgamesreview;

import android.content.Context;

import com.example.andr.androidgamesreview.Model.Categoria;

import java.util.List;

/**
 * Created by amand on 10/01/2016.
 */
public class DatabaseInsert {

    public DatabaseInsert(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        List<Categoria> categorias = db.getAllCategorias();
        List<Produtora> produtoras = db.getAllProdutoras();
        List<Jogo> jogos = db.getAllJogos();

        if (categorias.size() == 0){
            insert_Dados(context);
        } else if (produtoras.size() == 0){
            insert_Dados(context);
        } else if(jogos.size() == 0){
            insert_Dados(context);
        }
    }

    public void insert_Dados(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.addCategoria(new Categoria("Arcada"));
        db.addCategoria(new Categoria("Cartas"));
        db.addCategoria(new Categoria("Desporto"));
        db.addCategoria(new Categoria("Corridas"));

        db.addProdutora(new Produtora("Clean Master Games"));
        db.addProdutora(new Produtora("TaoGames Limited"));
        db.addProdutora(new Produtora("First Touch"));
        db.addProdutora(new Produtora("Kiloo"));
        db.addProdutora(new Produtora("Miniclip.com"));
        db.addProdutora(new Produtora("Electronic Arts"));

        db.addJogo(new Jogo("Piano Tiles", "Piano Tiles 2 é a sequência do Piano Tiles (Don't Tap the White Tile), " +
                "que é mundialmente conhecido e popular. " +
                "Nova jogabilidade, a qualidade de som de primeira e o modo de competição " +
                "global lhe trará a emoção ao controlar o dedo e prazer de tocar piano.", 4.7, "pianotiles",
                "https://youtu.be/kkvSM-0vxHg", "https://play.google.com/store/apps/details?id=com.cmplay.tiles2", "1", "1"));

        db.addJogo(new Jogo("Solitário", "Jogue o #1 jogo de cartas Solitário (ou Solitário Klondike / Paciência) no Android!\n" +
                "Solitário Clássico, também conhecido como Paciência, é o jogo de cartas mais popular do mundo. " +
                "Experimente o nosso app de cartas, o MELHOR SOLITÁRIO GRÁTIS," +
                " que é bonito e divertido como o Solitário clássico do Windows.", 4.7, "solitario",
                "", "https://play.google.com/store/apps/details?id=com.spacegame.solitaire.basic", "2", "2"));

        db.addJogo(new Jogo("Score! Hero", "Score! Hero, dos premiados criadores de Score! World Goals, Dream League Soccer e First Touch Soccer.\n" +
                "SEJA UM HERÓI! Passe, chute e marque seu caminho até um status de lenda, enquanto explora a dramática " +
                "carreira do seu HERÓI por 320 níveis desafiadores!", 4.7, "scorehero",
                "https://youtu.be/M5XXJ_rNzNc", "https://play.google.com/store/apps/details?id=com.firsttouchgames.story", "3", "3"));

        db.addJogo(new Jogo("Subway Surfers", "DASH as fast as you can! \n" +
                "DODGE the oncoming trains!\n" +
                "Help Jake, Tricky & Fresh escape from the grumpy Inspector and his dog.", 4.4, "subwaysurfers",
                "https://youtu.be/fUk_eBKL3q8", "https://play.google.com/store/apps/details?id=com.kiloo.subwaysurf", "4", "1"));

        db.addJogo(new Jogo("8 Ball Pool", "O jogo de bilhar nº 1 do mundo - agora para Android!•\n" +
                "Joga com amigos! Joga com lendas. Joga o famoso jogo 8 Ball Pool da Miniclip no " +
                "teu dispositivo móvel e torna-te o melhor!", 4.5, "eightballpool",
                "https://youtu.be/MarGQrmbPm0", "https://play.google.com/store/apps/details?id=com.miniclip.eightballpool", "5", "3"));

        db.addJogo(new Jogo("Need for Speed™ No Limits", "Corra para dominar o asfalto na primeira edição eletrizante de Need for Speed feita só para dispositivos móveis – " +
                "dos mesmos desenvolvedores que deram a você Real Racing 3. Construa sua máquina dos sonhos com uma variedade inacreditável de veículos e personalizações. " +
                "Viva no limite tênue entre caos e controle, pisando fundo na subcultura dos carros de corrida urbanos. Ganhe corridas, aumente sua reputação e depois caia dentro de mais corridas, " +
                "mais personalizações e mais carrões. Faça suas escolhas e nunca olhe para trás. A noite é sua!\n" +
                "Este aplicativo oferece compras internas. Você pode desativar as compras pelo aplicativo nas configurações do seu dispositivo.", 4.3, "nfs",
                "https://youtu.be/9DQvlNm20x0", "https://play.google.com/store/apps/details?id=com.ea.game.nfs14_row", "6", "4"));

    }

}

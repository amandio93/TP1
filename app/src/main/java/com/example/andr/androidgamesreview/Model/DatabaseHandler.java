package com.example.andr.androidgamesreview.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: DatabaseHandler
 * Data entrega: 22/01/2016
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "jogos";

    private static final String TABELA_PRODUTORAS = "produtoras";
    private static final String KEY_COD_PRODUTORA = "cod_produtora";
    private static final String KEY_NOME_PRODUTORA = "produtora";

    private static final String TABELA_CATEGORIAS = "categorias";
    private static final String KEY_COD_CATEGORIA = "cod_categoria";
    private static final String KEY_NOME_CATEGORIA = "categoria";

    private static final String TABELA_JOGOS = "jogos";
    private static final String KEY_COD_JOGO = "cod_jogo";
    private static final String KEY_NOME_JOGO = "nome_jogo";
    private static final String KEY_DESCRICAO_JOGO = "descricao_jogo";
    private static final String KEY_CLASSIFICACAO_JOGO = "classificacao_jogo";
    private static final String KEY_NOME_IMAGEM_JOGO = "nome_imagem_jogo";
    private static final String KEY_LINK_VIDEO_JOGO = "link_video_jogo";
    private static final String KEY_LINK_STORE_JOGO = "link_store_jogo";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PODUTORAS = "CREATE TABLE IF NOT EXISTS " + TABELA_PRODUTORAS + "("
                + KEY_COD_PRODUTORA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOME_PRODUTORA + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_TABLE_PODUTORAS);

        String CREATE_TABLE_CATEGORIAS = "CREATE TABLE IF NOT EXISTS " + TABELA_CATEGORIAS + "("
                + KEY_COD_CATEGORIA + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOME_CATEGORIA + " TEXT NOT NULL" + ")";
        db.execSQL(CREATE_TABLE_CATEGORIAS);

        String CREATE_TABLE_JOGOS = "CREATE TABLE IF NOT EXISTS " + TABELA_JOGOS + "("
                + KEY_COD_JOGO + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + KEY_NOME_JOGO + " TEXT NOT NULL,"
                + KEY_DESCRICAO_JOGO + " TEXT NOT NULL,"
                + KEY_CLASSIFICACAO_JOGO + " DOUBLE NOT NULL,"
                + KEY_NOME_IMAGEM_JOGO + " TEXT,"
                + KEY_LINK_VIDEO_JOGO + " TEXT,"
                + KEY_LINK_STORE_JOGO + " TEXT,"
                + KEY_COD_PRODUTORA + " INTEGER NOT NULL,"
                + KEY_COD_CATEGORIA + " INTEGER NOT NULL,"
                + "FOREIGN KEY (" + KEY_COD_PRODUTORA + ")" +
                " REFERENCES " + TABELA_PRODUTORAS + "("+ KEY_COD_PRODUTORA +")" +
                " ON UPDATE CASCADE ON DELETE CASCADE," +
                " FOREIGN KEY (" + KEY_COD_CATEGORIA + ")" +
                "  REFERENCES " + TABELA_CATEGORIAS + "("+ KEY_COD_CATEGORIA +")" +
                " ON UPDATE CASCADE ON DELETE CASCADE)";
        db.execSQL(CREATE_TABLE_JOGOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTORAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CATEGORIAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_JOGOS);
        onCreate(db);
    }

    /**
     * Adicionar a produtora
     * @param produtora
     */
    public void addProdutora(Produtora produtora) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOME_PRODUTORA, produtora.get_nome_produtora());
        db.insert(TABELA_PRODUTORAS, null, values);
        db.close();
    }

    /**
     * Adicionar a categoria
     * @param categoria
     */
    public void addCategoria(Categoria categoria) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOME_CATEGORIA, categoria.get_nome_categoria());
        db.insert(TABELA_CATEGORIAS, null, values);
        db.close();
    }

    /**
     * Adicionar o jogo
     * @param jogo
     */
    public void addJogo(Jogo jogo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOME_JOGO, jogo.get_nome_jogo());
        values.put(KEY_DESCRICAO_JOGO, jogo.get_descricao_jogo());
        values.put(KEY_CLASSIFICACAO_JOGO, jogo.get_classificacao_jogo());
        values.put(KEY_NOME_IMAGEM_JOGO, jogo.get_nome_imagem_jogo());
        values.put(KEY_LINK_VIDEO_JOGO, jogo.get_link_video_jogo());
        values.put(KEY_LINK_STORE_JOGO, jogo.get_link_store_jogo());
        values.put(KEY_COD_PRODUTORA, jogo.get_cod_produtora());
        values.put(KEY_COD_CATEGORIA, jogo.get_cod_categoria());
        db.insert(TABELA_JOGOS, null, values);
        db.close();
    }


    public List<Categoria> getAllCategorias() {
        List<Categoria> categoriaList = new ArrayList<>();
        String selectQuery = "SELECT categoria FROM " + TABELA_CATEGORIAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Categoria categoria = new Categoria();
                categoria.set_nome_categoria(cursor.getString(0));
                categoriaList.add(categoria);
            } while (cursor.moveToNext());
        }
        return categoriaList;
    }

    public List<Produtora> getAllProdutoras() {
        List<Produtora> produtoraList = new ArrayList<>();

        String selectQuery = "SELECT produtora FROM " + TABELA_PRODUTORAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Produtora produtora = new Produtora();
                produtora.set_nome_produtora(cursor.getString(0));
                produtoraList.add(produtora);
            } while (cursor.moveToNext());
        }
        return produtoraList;
    }

    public List<Jogo> getAllJogos() {
        List<Jogo> jogosList = new ArrayList<>();
        String selectQuery = "SELECT nome_jogo FROM " + TABELA_JOGOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Jogo jogo = new Jogo();
                jogo.set_nome_jogo(cursor.getString(0));
                jogosList.add(jogo);
            } while (cursor.moveToNext());
        }
        return jogosList;
    }

    public List<Jogo> getAllJogos(String CodJogo) {
        List<Jogo> jogosList = new ArrayList<>();
        String selectQuery = "SELECT nome_jogo, classificacao_jogo, categorias.categoria, produtoras.produtora, " +
                " descricao_jogo, nome_imagem_jogo, link_video_jogo, link_store_jogo FROM "
                + TABELA_JOGOS + ", " + TABELA_CATEGORIAS + ", " + TABELA_PRODUTORAS +
                " WHERE categorias.cod_categoria=jogos.cod_categoria" +
                " AND produtoras.cod_produtora=jogos.cod_produtora" +
                " AND cod_jogo=" + CodJogo + "";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Jogo jogo = new Jogo();
                jogo.set_nome_jogo(cursor.getString(0));
                jogo.set_classificacao_jogo(cursor.getDouble(1));
                jogo.set_cod_categoria(cursor.getString(2));
                jogo.set_cod_produtora(cursor.getString(3));
                jogo.set_descricao_jogo(cursor.getString(4));
                jogo.set_nome_imagem_jogo(cursor.getString(5));
                jogo.set_link_video_jogo(cursor.getString(6));
                jogo.set_link_store_jogo(cursor.getString(7));
                jogosList.add(jogo);
            } while (cursor.moveToNext());
        }
        return jogosList;
    }
}

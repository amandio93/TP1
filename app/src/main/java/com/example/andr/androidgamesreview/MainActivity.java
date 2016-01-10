package com.example.andr.androidgamesreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.andr.androidgamesreview.Model.DatabaseInsert;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: MainActivity
 * Data entrega: 22/01/2016
 */
public class MainActivity extends AppCompatActivity {

    public String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseInsert dbInsert = new DatabaseInsert(this);

    }

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

}

package com.example.andr.androidgamesreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FragmentLocal extends AppCompatActivity {

    public String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_local);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("btnName");
        Log.d("btnName", buttonName);

        if( buttonName.equals("gameList")){
            listaDeJogosFragment listaDeJogosFragment = new listaDeJogosFragment();
            listaDeJogosFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, listaDeJogosFragment).commit();
        }

        if( buttonName.equals("categoria")){
            CategoriaListFragment categoriaListFragment = new CategoriaListFragment();
            categoriaListFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, categoriaListFragment).commit();
        }

    }
}

package com.example.andr.androidgamesreview;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FragmentLocal extends AppCompatActivity {

    private String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_local);

        Intent intent = getIntent();
        buttonName = intent.getStringExtra("btnName");
        Log.d("btnName", buttonName);

        checkVerital();
        checkHorizontal();

    }

    private void checkHorizontal(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            gameList_onClick(R.id.frag_cont1);
            categoriaList_onClick(R.id.frag_cont1);
            produtoraList_onClick(R.id.frag_cont1);
        }
    }

    private void checkVerital(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            gameList_onClick(R.id.fragment_container);
            categoriaList_onClick(R.id.fragment_container);
            produtoraList_onClick(R.id.fragment_container);
        }
    }

    private void gameList_onClick(Integer i){
        if( buttonName.equals("gameList")){
            JogoListFragment listaDeJogosFragment = new JogoListFragment();
            listaDeJogosFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(i, listaDeJogosFragment).commit();
        }
    }

    private void categoriaList_onClick(Integer i){
        if( buttonName.equals("categoria")){
            CategoriaListFragment categoriaListFragment = new CategoriaListFragment();
            categoriaListFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(i, categoriaListFragment).commit();
        }
    }

    private void produtoraList_onClick(Integer i){
        if( buttonName.equals("produtora")){
            ProdutoraListFragmnet produtoraListFragmnet = new ProdutoraListFragmnet();
            produtoraListFragmnet.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(i, produtoraListFragmnet).commit();
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }

}

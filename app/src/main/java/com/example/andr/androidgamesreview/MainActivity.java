package com.example.andr.androidgamesreview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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


}

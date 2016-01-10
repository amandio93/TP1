package com.example.andr.androidgamesreview;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.andr.androidgamesreview.Model.DatabaseHandler;
import com.example.andr.androidgamesreview.Model.Produtora;

import java.util.List;


/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: ProdutoraListFragment
 * Data entrega: 22/01/2016
 */
public class ProdutoraListFragmnet extends ListFragment {


    public ProdutoraListFragmnet() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Produtora> produtoras = db.getAllProdutoras();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        for (Produtora cn : produtoras) {
            adapter.add(cn.get_nome_produtora());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}



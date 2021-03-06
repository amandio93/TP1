package com.example.andr.androidgamesreview;


import android.graphics.Color;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.andr.androidgamesreview.Model.Categoria;
import com.example.andr.androidgamesreview.Model.DatabaseHandler;

import java.util.List;


/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: CategoriaListFragment
 * Data entrega: 22/01/2016
 */
public class CategoriaListFragment extends ListFragment {

    public CategoriaListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Categoria> categorias = db.getAllCategorias();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        for (Categoria cn : categorias) {
            String log = "Id: "+cn.get_cod_categoria()+" ,Name: " + cn.get_nome_categoria();
            Log.d("Name: ", log);
            adapter.add(cn.get_nome_categoria());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}

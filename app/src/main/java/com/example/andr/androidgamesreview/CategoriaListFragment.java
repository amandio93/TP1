package com.example.andr.androidgamesreview;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriaListFragment extends ListFragment {

    public CategoriaListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Categoria> categorias = db.getAllCategorias();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1);
       // adapter.addAll(db.getTodas().toString());
        for (Categoria cn : categorias) {
            String log = "Id: "+cn.get_cod_categoria()+" ,Name: " + cn.get_nome_categoria();
            Log.d("Name: ", log);
            adapter.add(cn.get_nome_categoria());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}

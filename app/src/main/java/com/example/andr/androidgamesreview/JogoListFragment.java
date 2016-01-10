package com.example.andr.androidgamesreview;

import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andr.androidgamesreview.Model.DatabaseHandler;
import com.example.andr.androidgamesreview.Model.Jogo;

import java.util.List;


/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: JogosListFragment
 * Data entrega: 22/01/2016
 */
public class JogoListFragment extends ListFragment {

    private String nameGamePortrait;
    private String nameGameLand;
    private String gameName;

    public JogoListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> jogos = db.getAllJogos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);
                TextView textView=(TextView) view.findViewById(android.R.id.text1);
                textView.setTextColor(Color.WHITE);
                return view;
            }
        };
        for (Jogo cn : jogos) {
            adapter.add(cn.get_nome_jogo());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        GameInfoFragment gameInfoFragment = new GameInfoFragment();
        Bundle args = new Bundle();
        args.putString(GameInfoFragment.ARG_POSITION, String.valueOf(position));
        gameInfoFragment.setArguments(args);

        gameName =  String.valueOf(position);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            transaction.replace(R.id.frag_cont2, gameInfoFragment);
        }else{
            transaction.replace(R.id.fragment_container, gameInfoFragment);
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    private void checkOrientationChange(){

    }

}

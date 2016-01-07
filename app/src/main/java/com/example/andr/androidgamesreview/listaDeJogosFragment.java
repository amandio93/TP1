package com.example.andr.androidgamesreview;

import android.content.res.Configuration;
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

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaDeJogosFragment extends ListFragment {

    private String nameGamePortrait;
    private String nameGameLand;
    private String gameName;

    public listaDeJogosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHandler db = new DatabaseHandler(getContext());
        List<Jogo> jogos = db.getAllJogos();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1);
        for (Jogo cn : jogos) {
            adapter.add(cn.get_nome_jogo());
        }
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        // Create fragment and give it an argument specifying the article it should show
        GameInfo gameInfoFragment = new GameInfo();
        Bundle args = new Bundle();
        args.putString(GameInfo.ARG_POSITION, String.valueOf(position));
        gameInfoFragment.setArguments(args);

        gameName =  getString(position);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            transaction.replace(R.id.frag_cont2, gameInfoFragment);
            //falta o return pro menu
        }else{
            transaction.replace(R.id.fragment_container, gameInfoFragment);
            transaction.addToBackStack(null);
        }

        // Commit the transaction
        transaction.commit();


    }

}

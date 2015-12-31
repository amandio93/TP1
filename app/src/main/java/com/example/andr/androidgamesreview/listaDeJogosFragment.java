package com.example.andr.androidgamesreview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaDeJogosFragment extends ListFragment {

    public listaDeJogosFragment() {
        // Required empty public constructor
    }

    String[] values = new String[] { "Jogo1", "Jogo2", "Jogo3" };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //gameListName = (ListView)view.findViewById(R.id.gameListName);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        // Create fragment and give it an argument specifying the article it should show
        GameInfo gameInfoFragment = new GameInfo();
        Bundle args = new Bundle();
        args.putInt("gameName", position);
        gameInfoFragment.setArguments(args);

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragment_container, gameInfoFragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();


    }
}

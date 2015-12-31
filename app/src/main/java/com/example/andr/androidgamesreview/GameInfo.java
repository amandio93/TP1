package com.example.andr.androidgamesreview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameInfo extends Fragment {

    String ARG_POSITION = "gameName";

    public GameInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        Integer argsInt = args.getInt(ARG_POSITION);
        Log.d("Arg Position", argsInt.toString());

        return inflater.inflate(R.layout.fragment_game_info, container, false);
    }

}

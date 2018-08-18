package com.shimoo.foodorderapp.screens.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shimoo.foodorderapp.R;


public class MyAcountFragment extends Fragment {

View root ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=  inflater.inflate(R.layout.fragment_my_acount, container, false);
        getActivity().setTitle("");
        getActivity().findViewById(R.id.toolbar).setBackgroundColor(Color.TRANSPARENT);

        return root ;

    }

}

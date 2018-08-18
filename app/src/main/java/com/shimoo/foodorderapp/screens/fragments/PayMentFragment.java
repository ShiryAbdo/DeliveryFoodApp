package com.shimoo.foodorderapp.screens.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shimoo.foodorderapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PayMentFragment extends Fragment {

 View roote;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        roote = inflater.inflate(R.layout.fragment_pay_ment, container, false);
        getActivity().setTitle("Payment Methods");
        getActivity().findViewById(R.id.toolbar).setBackgroundColor(Color.parseColor("#31D896"));
        return  roote ;
    }

}

package com.shimoo.foodorderapp.screens.fragments;


import android.annotation.SuppressLint;
 import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.Toast;

import com.shimoo.foodorderapp.R;
import com.shimoo.foodorderapp.adapters.AdaptersRestaurant;
import com.shimoo.foodorderapp.components.DaggerHomeActivityComponent;
import com.shimoo.foodorderapp.components.HomeActivityComponent;
import com.shimoo.foodorderapp.controls.MyApplicationClass;
import com.shimoo.foodorderapp.helper.IFragmentToActivity;
import com.shimoo.foodorderapp.models.Restaurants;
import com.shimoo.foodorderapp.modules.MainHomeActivityModule;
import com.shimoo.foodorderapp.network.ApiService;
 import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


 @SuppressLint("ValidFragment")
 public class ChineseFragment extends Fragment implements  IFragmentToActivity{


    @BindView(R.id.recycler_view) RecyclerView recycler_view;
    @Inject
    ApiService githubService;
    @Inject
    Picasso mPicasso;
    Call<Restaurants> reposCall;
      @Inject
    AdaptersRestaurant adapterRepos;
     List<Restaurants.RestaurantsBean> githubRepos = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         View root =inflater.inflate(R.layout.fragment_chinese, container, false);
        ButterKnife.bind(this,root);
        HomeActivityComponent component= DaggerHomeActivityComponent.builder()
                .mainHomeActivityModule(new MainHomeActivityModule(getActivity(),"chinese"))
                .componentInterFace(MyApplicationClass.get(getActivity()).getComponent())
                .build();
        component.getAdaptersRestaurant();
        component.injectChineseFragment(this);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
          recycler_view.setAdapter(adapterRepos);
//         if(githubRepos.isEmpty()){
        githubRepos= new ArrayList<>();

            reposCall = githubService.getRestaurants("59","city","25","ae5c9df3cbde209f3c36e8d9f7b47700");
            reposCall.enqueue(new Callback<Restaurants>() {
                @Override
                public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                    Restaurants restaurants =  response.body();
                     githubRepos= restaurants.getRestaurants() ;

                    if(!githubRepos.isEmpty())
                        adapterRepos.swapData(githubRepos ,getActivity());

                }

                @Override
                public void onFailure(Call<Restaurants> call, Throwable t) {
                    Toast.makeText(getActivity(),   t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

//        }


        return root ;

    }


    @Override
    public void sedData(List<Restaurants.RestaurantsBean> githubReps) {
        githubRepos=githubReps ;

    }
}

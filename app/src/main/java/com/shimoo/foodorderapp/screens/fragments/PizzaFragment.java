package com.shimoo.foodorderapp.screens.fragments;

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

 public class PizzaFragment extends Fragment {
     @BindView(R.id.recycler_view) RecyclerView recycler_view;
     @Inject
     ApiService githubService;
     @Inject
     Picasso mPicasso;
     Call<Restaurants> reposCall;
      @Inject
     AdaptersRestaurant adapterRepos;
    List<Restaurants.RestaurantsBean> PizzaData = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =inflater.inflate(R.layout.fragment_chinese, container, false);

        ButterKnife.bind(this,root);
        HomeActivityComponent component= DaggerHomeActivityComponent.builder()
                .mainHomeActivityModule(new MainHomeActivityModule(getActivity(),"pizza"))
                .componentInterFace(MyApplicationClass.get(getActivity()).getComponent())
                .build();
        component.getAdaptersRestaurant();
        component.injectTacosFragment(this);

        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_view.setAdapter(adapterRepos);
       getPizzaData("82","city", "168","ae5c9df3cbde209f3c36e8d9f7b47700");

        return root ;
    }
    private void getPizzaData( String entity_id ,String entity_type , String cuisines, String user_key){
//        if(PizzaData.isEmpty()){
        PizzaData= new ArrayList<>();

            reposCall = githubService.getRestaurants(entity_id,entity_type, cuisines,user_key);
            reposCall.enqueue(new Callback<Restaurants>() {
                @Override
                public void onResponse(Call<Restaurants> call, Response<Restaurants> response) {
                    Restaurants restaurants =  response.body();
                    PizzaData= restaurants.getRestaurants() ;
                    if(!PizzaData.isEmpty())
                        adapterRepos.swapData(PizzaData ,getActivity());

                }

                @Override
                public void onFailure(Call<Restaurants> call, Throwable t) {
                    Toast.makeText(getActivity(),   t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

//        }

    }




}


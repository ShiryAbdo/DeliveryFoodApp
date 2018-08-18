package com.shimoo.foodorderapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shimoo.foodorderapp.R;
import com.shimoo.foodorderapp.models.Restaurants;
import com.shimoo.foodorderapp.screens.fragments.DealsFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdaptersRestaurant  extends RecyclerView.Adapter<AdaptersRestaurant.ViewHolder> {
    private ArrayList<Restaurants.RestaurantsBean> androidList = new ArrayList<>();
    private final Picasso mPicasso;
    private  String data ;

    @Inject
    public AdaptersRestaurant(Picasso mPicasso ,String data) {
        this.mPicasso = mPicasso;
        this.data=data;
        androidList= new ArrayList<>();


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout. restaurants_row , viewGroup, false);




        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final AdaptersRestaurant
            .ViewHolder viewHolder, final int i) {
        if(!data.equals("deals")){
            viewHolder.RelativeLayoutDeals.setVisibility(View.GONE);
            viewHolder.LinearLayoutData.setVisibility(View.VISIBLE);
            if(!androidList.get(i).getRestaurant().getThumb().isEmpty()){
                mPicasso.load(androidList.get(i).getRestaurant().getThumb()).fit().into(viewHolder.restaurant_image);

            }
            viewHolder.location.setText(androidList.get(i).getRestaurant().getLocation().getAddress());
            viewHolder.restaurant_name.setText(androidList.get(i).getRestaurant().getName());
            viewHolder.rating1Bar.setRating(Float.parseFloat(androidList.get(i).getRestaurant().getUser_rating().getAggregate_rating()));
            Drawable drawable = viewHolder.rating1Bar.getProgressDrawable();
            drawable.setColorFilter(Color.parseColor("#"+androidList.get(i).getRestaurant().getUser_rating().getRating_color()), PorterDuff.Mode.SRC_ATOP);
            viewHolder.votes_number.setText("("+androidList.get(i).getRestaurant().getUser_rating().getVotes()+")");
            viewHolder.number.setText(androidList.get(i).getRestaurant().getAverage_cost_for_two()+"");

        }else {
            viewHolder.RelativeLayoutDeals.setVisibility(View.VISIBLE);
            viewHolder.LinearLayoutData.setVisibility(View.GONE);
            if(!androidList.get(i).getRestaurant().getThumb().isEmpty()){
                mPicasso.load(androidList.get(i).getRestaurant().getThumb()).fit().into(viewHolder.restaurant_imag);

            }
            viewHolder.restaurant_nam.setText(androidList.get(i).getRestaurant().getName());



        }


    }





    @Override
    public int getItemCount() {


        return androidList.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.restaurant_image) ImageView restaurant_image;
        @BindView(R.id.new_image)ImageView restaurant_imag ;
        @BindView(R.id.number) TextView number;
        @BindView(R.id.restaurant_nam)TextView restaurant_nam ;
        @BindView(R.id.location) TextView location;
        @BindView(R.id.restaurant_name) TextView restaurant_name;
        @BindView(R.id.ratingBar) RatingBar rating1Bar;
        @BindView(R.id.votes_number)TextView votes_number ;
        @BindView(R.id.RelativeLayoutDeals)RelativeLayout RelativeLayoutDeals;
        @BindView(R.id.LinearLayoutData)RelativeLayout LinearLayoutData;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);




        }
    }

    public void swapData(List<Restaurants.RestaurantsBean> githubRepos , Context context) {
        androidList.clear();
        androidList.addAll(githubRepos);
 //        Toast.makeText(context, "hhhhh", Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
      }




}
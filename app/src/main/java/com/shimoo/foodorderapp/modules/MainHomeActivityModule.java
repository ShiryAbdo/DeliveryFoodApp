package com.shimoo.foodorderapp.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shimoo.foodorderapp.annotations.MainHomeActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainHomeActivityModule {

    private final Activity homeActivity;
    private  String data ;
     @MainHomeActivityScope
    public MainHomeActivityModule(Activity homeActivity ,String data) {

         this.homeActivity = homeActivity;
         this.data=data;
    }


    @Provides
    @MainHomeActivityScope
    public Activity provideHomeActivity(){
        return homeActivity;
    }
    @Provides
    public String getData() {
        return data;
    }

    @Provides
    public RecyclerView.LayoutManager providesLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }
}

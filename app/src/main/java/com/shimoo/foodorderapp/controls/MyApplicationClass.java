package com.shimoo.foodorderapp.controls;

import android.app.Activity;
import android.app.Application;

import com.shimoo.foodorderapp.components.ComponentInterFace;
import com.shimoo.foodorderapp.components.DaggerComponentInterFace;
import com.shimoo.foodorderapp.modules.ContextModule;
import com.shimoo.foodorderapp.network.ApiService;
import com.squareup.picasso.Picasso;

public class MyApplicationClass   extends Application {

    private ComponentInterFace componentInterFace ;
    private ApiService apiService;
    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();
        componentInterFace = DaggerComponentInterFace.builder()
                .contextModule(new ContextModule(this))
                .build();

        // access these componentInterFace
        apiService = componentInterFace.getApiService();
        picasso = componentInterFace.getPicasso();
    }
    public ComponentInterFace getComponent() {
        return componentInterFace;
    }


    public static MyApplicationClass get(Activity activity) {
        return (MyApplicationClass) activity.getApplication();
    }
}

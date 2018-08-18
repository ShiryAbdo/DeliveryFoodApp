package com.shimoo.foodorderapp.components;

import com.shimoo.foodorderapp.annotations.ApiServiceScope;
import com.shimoo.foodorderapp.modules.ApiServiceModule;
import com.shimoo.foodorderapp.modules.MainHomeActivityModule;
import com.shimoo.foodorderapp.modules.PicassoModule;
import com.shimoo.foodorderapp.network.ApiService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@ApiServiceScope
@Component(modules = {ApiServiceModule.class, PicassoModule.class , MainHomeActivityModule.class})
public interface ComponentInterFace {
    Picasso getPicasso();
    ApiService getApiService();
}

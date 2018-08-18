package com.shimoo.foodorderapp.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shimoo.foodorderapp.annotations.ApiServiceScope;
import com.shimoo.foodorderapp.network.ApiService;
import com.shimoo.foodorderapp.network.DateTimeConverter;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class ApiServiceModule {

    @Provides
    @ApiServiceScope
    public ApiService getApiService(Retrofit gitHubRetrofit){
        return gitHubRetrofit.create(ApiService.class);
    }

    @Provides
    @ApiServiceScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    @ApiServiceScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient) // tell retrofit to use our OkHttpClient
                .baseUrl("https://developers.zomato.com/")
                .build();
    }
}

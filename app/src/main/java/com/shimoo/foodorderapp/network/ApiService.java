package com.shimoo.foodorderapp.network;

import com.shimoo.foodorderapp.models.Restaurants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
//https://developers.zomato.com/api/v2.1/search?entity_id=59&entity_type=city
// searsh https://developers.zomato.com/api/v2.1/search?entity_id=59&entity_type=city&q=Eat%2C%20food%2C%20location%2C%20map%2C%20meal%2C%20pin%2C%20restaurant%20icon&count=200&category=chinese

//https://developers.zomato.com/api/v2.1/search?entity_id=59&
// entity_type=city&
// q=Eat%2C%20food%2C%20location%2C%20map%2C%20meal%2C%20pin%2C%20restaurant%20icon

//https://developers.zomato.com/api/v2.1/search?entity_id=59&entity_type=city
public interface ApiService {
    @GET("api/v2.1/search?")
    Call<Restaurants> getRestaurants(@Query("entity_id") String entity_id ,
                                           @Query("entity_type") String entity_type ,
                                           @Query("cuisines")String cuisines,
                                           @Header("user_key") String user_key);
    @GET("api/v2.1/search?")
    Call<Restaurants> getAllRestaurants(@Query("entity_id") String entity_id ,
                                     @Query("entity_type") String entity_type ,
                                        @Header("user_key") String user_key);
    @GET("api/v2.1/search?")
    Call<Restaurants> getSearchRestaurants(@Query("entity_id") String entity_id ,
                                        @Query("entity_type") String entity_type ,
                                           @Query("q") String q ,
                                        @Header("user_key") String user_key);
}

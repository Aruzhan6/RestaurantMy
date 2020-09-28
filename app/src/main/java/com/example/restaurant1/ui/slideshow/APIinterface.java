package com.example.restaurant1.ui.slideshow;


import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("restaurants")
    Call<RestaurantResponse> getRestaurant();

}

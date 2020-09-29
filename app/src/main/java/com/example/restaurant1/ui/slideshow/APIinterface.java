package com.example.restaurant1.ui.slideshow;


import com.example.restaurant1.ui.gallery.DelpapaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIinterface {
    @GET("restaurants")
    Call<RestaurantResponse> getRestaurant();

    @GET("slider")
    Call<DelpapaResponse> getDelpapa();
}

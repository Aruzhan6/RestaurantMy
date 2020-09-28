package com.example.restaurant1.ui.slideshow;

import java.util.List;

public class RestaurantResponse {
    public String code;
    public String message;
    public List<Restaurant> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Restaurant> getData() {
        return data;
    }

    public void setData(List<Restaurant> data) {
        this.data = data;
    }
}

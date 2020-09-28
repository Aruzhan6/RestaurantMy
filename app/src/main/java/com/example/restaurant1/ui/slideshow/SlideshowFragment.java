package com.example.restaurant1.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant1.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {
    RecyclerView recyclerView1;
    RestaurantAdapter restaurantAdapter;
    List<Restaurant> restaurantList;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycler_view_1);
        restaurantList = new ArrayList<>();

        restaurantAdapter = new RestaurantAdapter(restaurantList, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView1.setAdapter(restaurantAdapter);
        recyclerView1.setLayoutManager(mLayoutManager);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        recyclerView1.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        Call<RestaurantResponse> call = APIclient.apIinterface().getRestaurant();
        call.enqueue(new Callback<RestaurantResponse>() {
            @Override
            public void onResponse(Call<RestaurantResponse> call, Response<RestaurantResponse> response) {
                if (response.isSuccessful()) {
                    restaurantAdapter.setData(response.body().data);
                    Toast.makeText(getActivity().getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getActivity().getApplicationContext(), "An error Occured ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RestaurantResponse> call, Throwable t) {
                Toast.makeText(getActivity().getApplicationContext(), "An error Occured ", Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
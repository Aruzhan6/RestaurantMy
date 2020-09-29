package com.example.restaurant1.ui.gallery;

import android.os.Bundle;
import android.util.Log;
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
import com.example.restaurant1.ui.slideshow.APIclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    DelpapaAdapter delpapaAdapter;
    List<Delpapa> delpapaList;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        delpapaList = new ArrayList<>();

        delpapaAdapter = new DelpapaAdapter(delpapaList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setAdapter(delpapaAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        Call<DelpapaResponse> call = APIclient.apIinterface().getDelpapa();
        call.enqueue(new Callback<DelpapaResponse>() {
            @Override
            public void onResponse(Call<DelpapaResponse> call, Response<DelpapaResponse> response) {
                if (response.isSuccessful()){

                    delpapaAdapter.setData(response.body().data);

                    //Toast.makeText(getActivity().getApplicationContext(), "OK", Toast.LENGTH_LONG).show();
                    //Log.d("result", response.body().data.toString());
                }else{
                    // recyclerView.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity().getApplicationContext(), "An error Occured ", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DelpapaResponse> call, Throwable t) {
                //recyclerView.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity().getApplicationContext(), "An error Occured ", Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }
}
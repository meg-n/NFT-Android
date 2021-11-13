package com.example.nftapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView assetRV;
    private ArrayList<Asset> assetList;
    private AssetRVAdapter assetRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assetRV = findViewById(R.id.assetsRVID);
        assetList = new ArrayList<>();
        assetRVAdapter = new AssetRVAdapter(assetList,this);
        assetRV.setLayoutManager(new LinearLayoutManager(this));
        assetRV.setAdapter(assetRVAdapter);
        getNFT();
        assetRVAdapter.notifyDataSetChanged();
    }
    private void getAssets(int position){
        //assetList.add(new AssetModel(assetList));
        assetRVAdapter.notifyDataSetChanged();
    }
    private void getNFT(){
        assetList.clear();
        String openSeaURL = "https://mighty-brook-33468.herokuapp.com/get-assets";
        final String BASE_URL = "https://mighty-brook-33468.herokuapp.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        Call<AssetModel> call = retrofitAPI.getAllAssets(openSeaURL);
        call.enqueue(new Callback<AssetModel>() {
            @Override
            public void onResponse(Call<AssetModel> call, Response<AssetModel> response) {
                AssetModel assetModel = response.body();
                ArrayList<Asset> assets = assetModel.getAssets();
                for(Asset asset :assets){
                    assetList.add(new Asset(asset.getId(),asset.getImgUrl(),asset.getDescription()));
                }
                assetRVAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<AssetModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed to get assts", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
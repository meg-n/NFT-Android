package com.example.nftapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<AssetModel> getAllAssets(@Url String url);

}

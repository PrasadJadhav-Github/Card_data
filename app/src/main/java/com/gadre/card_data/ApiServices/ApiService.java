package com.gadre.card_data.ApiServices;

import com.gadre.card_data.Model.CarInfo;
import com.gadre.card_data.Model.DisplayFullInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("v1/cars")
    Call<ArrayList<CarInfo>> getCars();

    @GET("v1/cars/{id}")
    Call<DisplayFullInfo> getFullCarDetails(@Path("id") int id);


}

package com.gadre.card_data.Classes;

import android.util.Log;

import com.gadre.card_data.ApiServices.ApiService;
import com.gadre.card_data.ApiServices.RetrofitClient;
import com.gadre.card_data.Interface.DisplayCarInfo;
import com.gadre.card_data.Interface.DisplayInterface;
import com.gadre.card_data.Model.CarInfo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayCars implements DisplayInterface {
    private ApiService apiService;
    private DisplayCarInfo displayCarInfo;

    public DisplayCars(DisplayCarInfo displayCarInfo) {
        this.displayCarInfo = displayCarInfo;
        apiService = RetrofitClient.getCarInfo();

    }

    @Override
    public void DisplayCarsInfo() {
        Call<ArrayList<CarInfo>> call = apiService.getCars();
        call.enqueue(new Callback<ArrayList<CarInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<CarInfo>> call, Response<ArrayList<CarInfo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<CarInfo> carInfoArrayList = response.body();
                    displayCarInfo.onDataReceived(carInfoArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CarInfo>> call, Throwable t) {
                Log.e("CarInfo", "API call failed: " + t.getMessage());
            }
        });
    }

    @Override
    public void DisplayAllCars(int id) {

    }



}

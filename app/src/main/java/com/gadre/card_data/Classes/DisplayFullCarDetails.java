package com.gadre.card_data.Classes;

import android.util.Log;

import com.gadre.card_data.ApiServices.ApiService;
import com.gadre.card_data.ApiServices.RetrofitClient;
import com.gadre.card_data.Interface.DisplayCarInfo;
import com.gadre.card_data.Interface.DisplayInterface;
import com.gadre.card_data.Model.DisplayFullInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayFullCarDetails implements DisplayInterface {
    private final ApiService apiService;
    private final DisplayCarInfo displayCarInfo;

    public DisplayFullCarDetails(DisplayCarInfo displayCarInfo) {
        this.apiService = RetrofitClient.getCarInfo();
        this.displayCarInfo = displayCarInfo;
    }

    @Override
    public void DisplayAllCars(int id) {
        Call<DisplayFullInfo> call = apiService.getFullCarDetails(id);
        call.enqueue(new Callback<DisplayFullInfo>() {
            @Override
            public void onResponse(Call<DisplayFullInfo> call, Response<DisplayFullInfo> response) {
                if (response.isSuccessful() && response.body() != null) {
                   DisplayFullInfo displayFullInfo = response.body();
                    displayCarInfo.onCarDetailsReceived(displayFullInfo);

                    String images =displayFullInfo.getImage();
                    if (images!=null && images.isEmpty()){
                        displayCarInfo.onDataReceived(images);
                    }
                } else {
                    System.out.println("Response not successful: " + response.code() + ", Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<DisplayFullInfo> call, Throwable t) {
                System.out.println("API call failed: " + t.getMessage());
            }

        });
    }

    @Override
    public void DisplayCarsInfo() {

    }
}

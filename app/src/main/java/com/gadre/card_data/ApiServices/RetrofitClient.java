package com.gadre.card_data.ApiServices;

import static retrofit2.Retrofit.*;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static ApiService apiService = null;

    public static ApiService getCarInfo() {
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://freetestapi.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiService=retrofit.create(ApiService.class);
        }
        return apiService;
    }
}

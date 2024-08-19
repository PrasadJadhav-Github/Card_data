package com.gadre.card_data.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gadre.card_data.Adapter.CarInfoAdapter;
import com.gadre.card_data.ApiServices.ApiService;
import com.gadre.card_data.ApiServices.RetrofitClient;
import com.gadre.card_data.Classes.DisplayCars;
import com.gadre.card_data.Interface.DisplayCarInfo;
import com.gadre.card_data.Interface.DisplayInterface;
import com.gadre.card_data.Model.CarInfo;
import com.gadre.card_data.Model.DisplayFullInfo;
import com.gadre.card_data.R;
import com.gadre.card_data.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DisplayCarInfo {

    private ActivityMainBinding binding;
    private CarInfoAdapter carInfoAdapter;
    private RecyclerView recyclerView;
    private ArrayList<CarInfo> carInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView =binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        carInfoList = new ArrayList<>();
        carInfoAdapter =new CarInfoAdapter(carInfoList,this);
        recyclerView.setAdapter(carInfoAdapter);

        DisplayCars displayCar =new DisplayCars(this);
        displayCar.DisplayCarsInfo();


    }



    @Override
    public void onDataReceived(ArrayList<CarInfo> carInfoArrayList) {
        carInfoList.clear();
        carInfoList.addAll(carInfoArrayList);
        carInfoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCarDetailsReceived(DisplayFullInfo displayFullInfoList) {}




}
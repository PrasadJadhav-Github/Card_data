package com.gadre.card_data.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gadre.card_data.Adapter.CarInfoAdapter;
import com.gadre.card_data.ApiServices.ApiService;
import com.gadre.card_data.Classes.DisplayCars;
import com.gadre.card_data.Classes.DisplayFullCarDetails;
import com.gadre.card_data.Interface.DisplayCarInfo;
import com.gadre.card_data.Interface.DisplayInterface;
import com.gadre.card_data.Model.CarInfo;
import com.gadre.card_data.Model.DisplayFullInfo;
import com.gadre.card_data.Model.Features;
import com.gadre.card_data.R;
import com.gadre.card_data.databinding.ActivityCarDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsActivity extends AppCompatActivity implements DisplayCarInfo {

    private ActivityCarDetailsBinding binding;
    private ArrayList<DisplayFullInfo> fullCarInfoList;
    private TextView carDetailsTextView;
    // private  int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCarDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Retrieve car information from the Intent
        Intent intent = getIntent();
        CarInfo carInfo = intent.getParcelableExtra("car_info");


        if (carInfo != null) {
            DisplayFullCarDetails displayFullCarDetails = new DisplayFullCarDetails(this);
            displayFullCarDetails.DisplayAllCars(carInfo.getId());
        }

    }


    @Override
    public void onCarDetailsReceived(DisplayFullInfo displayFullInfoList) {

        if (displayFullInfoList != null) {
            binding.idTextView.setText("ID: " + displayFullInfoList.getId());
            binding.markTextView.setText("Make: " + displayFullInfoList.getMark());
            binding.modelTextView.setText("Model: " + displayFullInfoList.getModel());
            binding.yearTextView.setText("Year: " + displayFullInfoList.getYear());
            binding.colorTextView.setText("Color: " + displayFullInfoList.getColor());
            binding.markTextView.setText("Mileage: " + displayFullInfoList.getMileage() + " miles");
            binding.priceTextView.setText("Price: $" + displayFullInfoList.getPrice());
            binding.fuelTypeTextView.setText("Fuel Type: " + displayFullInfoList.getFuelType());
            binding.transmissionTextView.setText("Transmission: " + displayFullInfoList.getTransmission());
            binding.enginTextView.setText("Engine: " + displayFullInfoList.getEngine());
            binding.horsepowerTextView.setText("Horsepower: " + displayFullInfoList.getHorsepower() + " HP");
            binding.ownersTextView.setText("Owners: " + displayFullInfoList.getOwners());

            Glide.with(this)
                    .load(displayFullInfoList.getImage())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(binding.carImageView);


        }
    }




    @Override
    public void onDataReceived(ArrayList<CarInfo> carInfoArrayList) {

    }

}




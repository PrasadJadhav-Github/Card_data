package com.gadre.card_data.Interface;

import com.gadre.card_data.Model.CarInfo;
import com.gadre.card_data.Model.DisplayFullInfo;

import java.util.ArrayList;
import java.util.List;

public interface DisplayCarInfo {
    void onDataReceived(ArrayList<CarInfo> carInfoArrayList);

    void  onCarDetailsReceived(DisplayFullInfo displayFullInfoList);

}



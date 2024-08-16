package com.gadre.card_data.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class CarInfo implements Parcelable {

    private  int id;
    private String make;
    private  String model;
    private String color;

    protected CarInfo(Parcel in) {
        id = in.readInt();
        make = in.readString();
        model = in.readString();
        color = in.readString();
    }

    public static final Creator<CarInfo> CREATOR = new Creator<CarInfo>() {
        @Override
        public CarInfo createFromParcel(Parcel in) {
            return new CarInfo(in);
        }

        @Override
        public CarInfo[] newArray(int size) {
            return new CarInfo[size];
        }
    };

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(make);
        parcel.writeString(model);
        parcel.writeString(color);
    }
}

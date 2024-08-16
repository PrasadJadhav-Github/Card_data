package com.gadre.card_data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisplayFullInfo {
    @SerializedName("id")
    private int id;

    @SerializedName("make")
    private String mark;

    @SerializedName("model")
    private String model;

    @SerializedName("year")
    private String year;

    @SerializedName("color")
    private String color;

    @SerializedName("mileage")
    private int mileage;

    @SerializedName("price")
    private int price;

    @SerializedName("fuelType")
    private String fuelType;

    @SerializedName("transmission")
    private String transmission;

    @SerializedName("engine")
    private String engine;

    @SerializedName("horsepower")
    private int horsepower;

    //    @SerializedName("features")
//    private List<Features> features;
//
    @SerializedName("owners")
    private int owners;
    @SerializedName("image")
    private String image;

    public void setModel(String model) {
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    //    public List<Features> getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(List<Features> features) {
//        this.features = features;
//    }
//
    public int getOwners() {
        return owners;
    }

    public void setOwners(int owners) {
        this.owners = owners;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

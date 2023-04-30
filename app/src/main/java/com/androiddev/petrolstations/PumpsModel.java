package com.androiddev.petrolstations;

public class PumpsModel {
    String pumpName,location,petrol,diesel,food,washrooms,cashless,air,lat,lng;
    public PumpsModel(){

    }

    public PumpsModel(String pumpName, String location, String petrol, String diesel, String food, String washrooms, String cashless, String air,String lat,String lng) {
        this.pumpName = pumpName;
        this.location = location;
        this.petrol = petrol;
        this.diesel = diesel;
        this.food = food;
        this.washrooms = washrooms;
        this.cashless = cashless;
        this.air = air;
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPumpName() {
        return pumpName;
    }

    public void setPumpName(String pumpName) {
        this.pumpName = pumpName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPetrol() {
        return petrol;
    }

    public void setPetrol(String petrol) {
        this.petrol = petrol;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getWashrooms() {
        return washrooms;
    }

    public void setWashrooms(String washrooms) {
        this.washrooms = washrooms;
    }

    public String getCashless() {
        return cashless;
    }

    public void setCashless(String cashless) {
        this.cashless = cashless;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }
}

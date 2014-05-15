package com.xpanxion.skeleton.dto.beans.forms;

public class CarForm {

    private String carType;

    private int fuelLevel;

    private int price;

    private boolean hybrid;

    private boolean onSale;

    public String getCarType() {
        return this.carType;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public boolean getHybrid() {
        return this.hybrid;
    }

    public boolean getOnSale() {
        return this.onSale;
    }

    public int getPrice() {
        return this.price;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setHybrid(boolean hybrid) {
        this.hybrid = hybrid;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car Type: " + this.carType.toString() + " Fuel Level: " + this.fuelLevel + " Price: " + this.price + " Is hybrid: " + this.hybrid + " Is on Sale: " + this.onSale;
    }
}

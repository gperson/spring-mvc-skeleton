package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.enums.FuelType;

public abstract class Car {

    protected static String IMAGES = "/resources/images/";

    private FuelType fuel;
    private int carId;
    private int lotId;
    private int fuelLevel;
    private int fuelCapcity;
    private int fuelUsedToDrive;
    private int price;
    private boolean isHybrid;
    private String image;
    private boolean isOnSale;

    private CarType carType;

    public int getCarId() {
        return this.carId;
    }

    public CarType getCarType() {
        return this.carType;
    }

    public FuelType getFuel() {
        return this.fuel;
    }

    public int getFuelCapcity() {
        return this.fuelCapcity;
    }

    public int getFuelLevel() {
        return this.fuelLevel;
    }

    public int getFuelUsedToDrive() {
        return this.fuelUsedToDrive;
    }

    public String getImage() {
        return this.image;
    }

    public int getLotId() {
        return this.lotId;
    }

    public int getPrice() {
        return this.price;
    }

    public int getSalePrice() {
        return (int) (this.price * .8);
    }

    public void initialize() {
        this.setFuelCapcity(14);
        this.setFuelUsedToDrive(3);
        this.setPrice(20000);
        this.setFuelLevel(this.fuelCapcity);
        this.setFuel(FuelType.GAS);
        this.setHybrid(false);
        this.setOnSale(false);
    }

    public boolean isHybrid() {
        return this.isHybrid;
    }

    public boolean isOnSale() {
        return this.isOnSale;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public void setFuel(FuelType fuel) {
        this.fuel = fuel;
    }

    public void setFuelCapcity(int fuelCapcity) {
        this.fuelCapcity = fuelCapcity;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public void setFuelUsedToDrive(int fuelUsedToDrive) {
        this.fuelUsedToDrive = fuelUsedToDrive;
    }

    public void setHybrid(boolean isHybrid) {
        this.isHybrid = isHybrid;
        if (isHybrid) {
            this.fuelUsedToDrive = this.fuelUsedToDrive - 2;
        }
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public void setOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ("CarId: " + this.carId + " LotId: " + this.lotId + " FuelType: " + this.fuel + " FuelLevel: " + this.fuelLevel + " FuelCapcity: " + this.fuelCapcity
                + " FuelUsedToDrive: " + this.fuelUsedToDrive + " Price: " + this.price + " HasHybrid: " + this.isHybrid + " CarType: " + this.carType + " IsOnSale: " + this.isOnSale);
    }
}

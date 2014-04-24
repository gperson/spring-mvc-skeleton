package com.xpanxion.skeleton.dto.beans;

public abstract class Car {

    private Fuel fuel;
    private int fuelLevel;
    private int fuelCapcity;
    private int fuelUsedToDrive;
    private int price;
    private boolean hasHybrid;

    public Car() {
        this.initialize();
    }

    public Car(boolean hasHybrid) {
        this.initialize();
        this.setIsHybrid(hasHybrid);
    }

    public Fuel getFuel() {
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
        this.setFuel(Fuel.GAS);
        this.setIsHybrid(false);
    }

    public boolean isHybrid() {
        return this.hasHybrid;
    }

    public void setFuel(Fuel fuel) {
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

    public void setIsHybrid(boolean hasHybrid) {
        this.hasHybrid = hasHybrid;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

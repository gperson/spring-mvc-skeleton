package com.xpanxion.skeleton.dto.beans;

public class SemiTruck extends Car {

    public SemiTruck() {
        super();
        this.initialize();
    }

    public SemiTruck(boolean hasHybrid) {
        super(hasHybrid);
        this.initialize();
        this.setFuelUsedToDrive(this.getFuelUsedToDrive() - 2);
    }

    @Override
    public void initialize() {
        this.setPrice(50000);
        this.setFuel(Fuel.DIESEL);
        this.setFuelCapcity(50);
    }
}

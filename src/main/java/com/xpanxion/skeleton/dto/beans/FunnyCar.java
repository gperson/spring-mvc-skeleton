package com.xpanxion.skeleton.dto.beans;

public class FunnyCar extends Car {

    public FunnyCar() {
        super();
        this.initialize();
    }

    public FunnyCar(boolean isHybrid) {
        super(isHybrid);
        this.initialize();
        this.setFuelCapcity(12);
    }

    @Override
    public void initialize() {
        this.setFuelUsedToDrive(14);
        this.setFuel(Fuel.METHANOL);
    }
}

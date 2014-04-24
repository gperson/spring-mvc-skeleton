package com.xpanxion.skeleton.dto.beans;

public class Pinto extends Car {

    public Pinto() {
        super();
    }

    public Pinto(boolean hasHybrid) {
        super(hasHybrid);
        this.setFuelUsedToDrive(this.getFuelUsedToDrive() - 2);
    }

    @Override
    public int getSalePrice() {
        return (int) (this.getPrice() * .75);
    }
}

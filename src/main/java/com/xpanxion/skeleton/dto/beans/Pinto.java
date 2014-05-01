package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;

public class Pinto extends Car {

    public Pinto() {
        super.initialize();
        this.initialize();
    }

    public Pinto(boolean hasHybrid) {
        super.initialize();
        this.initialize();
        this.setHybrid(hasHybrid);
    }

    public Pinto(CarEntity car) {
        super.initialize();
        this.initialize();
        this.setCarId(car.getCarId());
        this.setCarType(car.getCarType());
        this.setFuelLevel(car.getFuelLevel());
        this.setLotId(car.getLotId());
        this.setPrice(car.getPrice());
        this.setHybrid(car.isHybrid());
        this.setOnSale(car.isOnSale());
    }

    @Override
    public int getSalePrice() {
        return (int) (this.getPrice() * .75);
    }

    @Override
    public void initialize() {
        this.setCarType(CarType.PINTO);
    }
}

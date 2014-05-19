package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;

public class Pinto extends Car {

    private final String IMAGE_FILE = "pinto.jpg";

    public Pinto() {
        super.initialize();
        this.initialize();
    }

    public Pinto(boolean hasHybrid, boolean isOnSale) {
        super.initialize();
        this.initialize();
        this.setHybrid(hasHybrid);
        this.setOnSale(isOnSale);
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
    public int getPrice() {
        if (this.isOnSale()) {
            return (int) (this.price * .75);
        } else {
            return super.getPrice();
        }
    }

    @Override
    public void initialize() {
        this.setImage(IMAGES + this.IMAGE_FILE);
        this.setCarType(CarType.PINTO);
    }
}

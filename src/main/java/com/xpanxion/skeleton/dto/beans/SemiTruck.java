package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.enums.FuelType;
import com.xpanxion.skeleton.dto.entity.CarEntity;

public class SemiTruck extends Car {

    private final String IMAGE_FILE = "semi.jpg";

    public SemiTruck() {
        super.initialize();
        this.initialize();
    }

    public SemiTruck(boolean hasHybrid, boolean isOnSale) {
        super.initialize();
        this.initialize();
        this.setHybrid(hasHybrid);
        this.setOnSale(isOnSale);
    }

    public SemiTruck(CarEntity car) {
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
    public void initialize() {
        this.setPrice(50000);
        this.setFuel(FuelType.DIESEL);
        this.setFuelCapcity(50);
        this.setImage(IMAGES + this.IMAGE_FILE);
        this.setCarType(CarType.SEMITRUCK);
    }
}

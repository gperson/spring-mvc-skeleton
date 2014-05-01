package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.enums.FuelType;
import com.xpanxion.skeleton.dto.entity.CarEntity;

public class SemiTruck extends Car {

    public SemiTruck() {
        super.initialize();
        this.initialize();
    }

    public SemiTruck(boolean hasHybrid) {
        super.initialize();
        this.initialize();
        this.setHybrid(hasHybrid);
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
        this.setImage(IMAGES + "semi.jpg");
        this.setCarType(CarType.SEMITRUCK);
    }
}

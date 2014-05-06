package com.xpanxion.skeleton.dto.beans;

import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.enums.FuelType;
import com.xpanxion.skeleton.dto.entity.CarEntity;

public class FunnyCar extends Car {

    private final String IMAGE_FILE = "funny.jpg";

    public FunnyCar() {
        super.initialize();
        this.initialize();
    }

    public FunnyCar(boolean isHybrid) {
        super.initialize();
        this.initialize();
        this.setHybrid(isHybrid);
    }

    public FunnyCar(CarEntity car) {
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
        this.setFuelUsedToDrive(14);
        this.setImage(IMAGES + this.IMAGE_FILE);
        this.setFuel(FuelType.METHANOL);
        this.setCarType(CarType.FUNNYCAR);
    }
}

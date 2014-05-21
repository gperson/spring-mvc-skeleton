package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.enums.CarType;

public interface CarService {

    public Car addCar(Lot lot, CarType car, int fuelLevel, boolean isHybrid, boolean isOnSale);

    public boolean driveCar(Car car);

    public void updateCar(Car car);

    public Car updateCar(Lot lot, String carId, int fuelLevel, boolean onSale);
}

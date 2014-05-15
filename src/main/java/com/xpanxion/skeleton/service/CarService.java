package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.enums.CarType;

public interface CarService {

    public boolean addOrSaveCar(Lot lot, CarType car, int fuelLevel, boolean isHybrid, boolean isOnSale);

}

package com.xpanxion.skeleton.service;

import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.enums.CarType;

public interface CarService {

    public void addOrSaveCar(Lot lot, CarType car, boolean isHybrid);

}

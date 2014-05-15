package com.xpanxion.skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.CarDao;
import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.FunnyCar;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.Pinto;
import com.xpanxion.skeleton.dto.beans.SemiTruck;
import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.entity.CarEntity;
import com.xpanxion.skeleton.service.CarService;

@Transactional
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    public static int MAX_CARLOT_SIZE = 25;

    @Override
    public boolean addOrSaveCar(Lot lot, CarType car, int fuelLevel, boolean isHybrid, boolean isOnSale) {
        boolean success = false;
        if (lot.getCars().size() < MAX_CARLOT_SIZE) {
            Car newCar;
            if (car == CarType.FUNNYCAR) {
                newCar = new FunnyCar(isHybrid, isOnSale);
            } else if (car == CarType.PINTO) {
                newCar = new Pinto(isHybrid, isOnSale);
            } else {
                newCar = new SemiTruck(isHybrid, isOnSale);
            }
            newCar.setLotId(lot.getId());
            newCar.setFuelLevel(fuelLevel);
            this.carDao.addCar(new CarEntity(newCar));
            success = true;
        }
        return success;
    }
}

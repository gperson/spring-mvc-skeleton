package com.xpanxion.skeleton.service.impl;

import javax.annotation.Resource;

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

    private CarDao carDao;
    public static int MAX_CARLOT_SIZE = 25;

    @Override
    public void addOrSaveCar(Lot lot, CarType car, boolean isHybrid) {
        System.out.println("Current lot size: " + lot.getCars().size());
        if (lot.getCars().size() < MAX_CARLOT_SIZE) {
            Car newCar;
            if (car == CarType.FUNNYCAR) {
                newCar = new FunnyCar(isHybrid);
            } else if (car == CarType.PINTO) {
                newCar = new Pinto(isHybrid);
            } else {
                newCar = new SemiTruck(isHybrid);
            }
            newCar.setLotId(lot.getId());
            System.out.println("Adding: " + newCar.toString());
            this.carDao.addCar(new CarEntity(newCar));
        }
    }

    @Resource
    public void setCarDao(CarDao doa) {
        this.carDao = doa;
    }
}
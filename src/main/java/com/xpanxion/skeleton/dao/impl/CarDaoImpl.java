package com.xpanxion.skeleton.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dao.CarDao;
import com.xpanxion.skeleton.dto.entity.CarEntity;

@Repository
public class CarDaoImpl implements CarDao {

    private SessionFactory sessionFactory;

    @Override
    public void addCar(CarEntity car) {
        Session sf = this.sessionFactory.openSession();
        Transaction transaction = sf.beginTransaction();
        sf.save(car);
        transaction.commit();
        sf.close();
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}

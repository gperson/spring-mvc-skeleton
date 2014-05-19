package com.xpanxion.skeleton.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dao.CarDao;
import com.xpanxion.skeleton.dto.entity.CarEntity;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCar(CarEntity car) {
        Session sf = this.sessionFactory.openSession();
        Transaction transaction = sf.beginTransaction();
        sf.save(car);
        transaction.commit();
        sf.close();
    }

    @Override
    public void udpateCar(CarEntity car) {
        Session sf = this.sessionFactory.openSession();
        Transaction transaction = sf.beginTransaction();
        sf.update(car);
        transaction.commit();
        sf.close();
    }
}

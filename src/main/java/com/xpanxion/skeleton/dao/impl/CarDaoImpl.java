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
    public int addCar(CarEntity car) {
        Session sf = this.sessionFactory.openSession();
        Transaction transaction = sf.beginTransaction();
        int id = (Integer) sf.save(car);
        transaction.commit();
        sf.close();
        return id;
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

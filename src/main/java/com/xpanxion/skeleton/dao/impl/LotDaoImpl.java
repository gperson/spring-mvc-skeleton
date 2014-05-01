package com.xpanxion.skeleton.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dao.LotDao;
import com.xpanxion.skeleton.dto.entity.LotEntity;

@Repository
public class LotDaoImpl implements LotDao {

    private SessionFactory sessionFactory;

    @Override
    public LotEntity getLot() {
        return (LotEntity) this.sessionFactory.openSession().getNamedQuery(LotEntity.GET_LOT_QUERY).uniqueResult();
    }

    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}

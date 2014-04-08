package com.xpanxion.skeleton.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     * 
     * @see com.xpanxion.skeleton.dao.TestDao#getAllItems()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> getAllItems() {
        return this.sessionFactory.openSession().getNamedQuery(UserEntity.GET_ALL_USERS).list();
    }

    /**
     * Gets the users info
     */
    @Override
    public UserEntity getUser(String user) {
        return (UserEntity) this.sessionFactory.openSession().getNamedQuery(UserEntity.GET_USER_BY_USERNAME).setString(UserEntity.GET_USER_BY_USERNAME_PARAMETER, user)
                .uniqueResult();
    }

    /**
     * Sets the session factory for this dao to use.
     * 
     * @param factory
     *            the session factory for this dao.
     */
    @Resource
    public void setSesionFactory(SessionFactory factory) {
        this.sessionFactory = factory;
    }
}

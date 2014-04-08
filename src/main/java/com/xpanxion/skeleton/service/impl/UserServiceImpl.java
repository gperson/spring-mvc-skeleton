package com.xpanxion.skeleton.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpanxion.skeleton.dao.UserDao;
import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.dto.entity.UserEntity;
import com.xpanxion.skeleton.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public UserBean getUserBean(String username) {
        UserEntity entity = this.userDao.getUser(username);
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setUsername(entity.getUsername());
        bean.setPassword(entity.getPassword());
        bean.setAuthority(entity.getAuthority());
        bean.setEnabled(entity.isEnabled());
        return bean;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.xpanxion.skeleton.service.UserService#getTestBeans()
     */
    @Override
    public List<UserBean> getUserBeans() {
        List<UserEntity> userItems = this.userDao.getAllItems();
        List<UserBean> output = new ArrayList<UserBean>();
        for (UserEntity entity : userItems) {
            UserBean bean = new UserBean();
            BeanUtils.copyProperties(entity, bean);
            bean.setUsername(entity.getUsername());
            bean.setPassword(entity.getPassword());
            bean.setAuthority(entity.getAuthority());
            bean.setEnabled(entity.isEnabled());
            output.add(bean);

        }
        return output;
    }

    /**
     * Sets the TestDao for this service to use
     * 
     * @param dao
     *            the dao for this service to use.
     */
    @Resource
    public void setTestDao(UserDao dao) {
        this.userDao = dao;
    }

}

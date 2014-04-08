package com.xpanxion.skeleton.service;

import java.util.List;

import com.xpanxion.skeleton.dto.beans.UserBean;

public interface UserService {

    /**
     * Returns user data
     * 
     * @param username
     * @return user bean
     */
    UserBean getUserBean(String username);

    /**
     * Return all of the available test beans.
     * 
     * @return all of the user beans
     */
    List<UserBean> getUserBeans();
}

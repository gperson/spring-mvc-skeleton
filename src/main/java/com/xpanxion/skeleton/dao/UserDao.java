package com.xpanxion.skeleton.dao;

import java.util.List;

import com.xpanxion.skeleton.dto.entity.UserEntity;

public interface UserDao {

    /**
     * Returns all of the user entities.
     * 
     * @return all of the user entities.
     */
    List<UserEntity> getAllItems();

    /**
     * Gets the users info
     * 
     * @return
     */
    UserEntity getUser(String username);
}

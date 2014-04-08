package com.xpanxion.skeleton.dto.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = UserEntity.GET_ALL_USERS, query = UserEntity.GET_ALL_USERS_QUERY),
        @NamedQuery(name = UserEntity.GET_USER_BY_USERNAME, query = UserEntity.GET_USER_BY_USERNAME_QUERY) })
public class UserEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4233290426045925212L;
    public static final String GET_ALL_USERS = "users.getAll";
    static final String GET_ALL_USERS_QUERY = "from UserEntity";
    public static final String GET_USER_BY_USERNAME = "users.getUser";
    public static final String GET_USER_BY_USERNAME_PARAMETER = "username";
    static final String GET_USER_BY_USERNAME_QUERY = "FROM UserEntity s WHERE s.username = :" + GET_USER_BY_USERNAME_PARAMETER;

    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String authority;

    @Column
    private boolean enabled;

    public String getAuthority() {
        return this.authority;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

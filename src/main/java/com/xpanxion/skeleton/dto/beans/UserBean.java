package com.xpanxion.skeleton.dto.beans;

public class UserBean {

    private String username;
    private String password;
    private String authority;
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

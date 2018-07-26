package com.dsy.entity;

import java.util.Set;

public class User {
    private Integer userid;

    private String username;

    private Set<Borrow> userBorrows;

    private Integer state;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<Borrow> getUserBorrows() {
        return userBorrows;
    }

    public void setUserBorrows(Set<Borrow> userBorrows) {
        this.userBorrows = userBorrows;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
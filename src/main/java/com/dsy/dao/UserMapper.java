package com.dsy.dao;

import com.dsy.entity.User;


public interface UserMapper {

    int insert(User user);

    User selectByPrimaryKey(Integer userid);

    User findByName(String username);

    void updateState(User user);

    User findByCode(String code);
}
package com.dsy.service;

import com.dsy.entity.Borrow;
import com.dsy.entity.User;

import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service
 */
public interface UserService {

    User login(String username);

    void register(User user);

    void updateState(User user);

    User findByUserId(Integer id);

    User findByCode(String code);
}

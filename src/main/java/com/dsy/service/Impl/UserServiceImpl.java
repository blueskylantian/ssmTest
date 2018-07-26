package com.dsy.service.Impl;

import com.dsy.dao.UserMapper;
import com.dsy.entity.Borrow;
import com.dsy.entity.User;
import com.dsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dsy on 2018/7/23
 * Package com.dsy.service.Impl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String username) {
        return userMapper.findByName(username);
    }



    public void register(User user) {
        userMapper.insert(user);
    }

    public void updateState(User user) {
        userMapper.updateState(user);
    }

    public User findByUserId(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User findByCode(String code) {
        return userMapper.findByCode(code);
    }
}

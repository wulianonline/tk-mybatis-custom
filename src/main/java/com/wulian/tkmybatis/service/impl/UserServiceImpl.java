package com.wulian.tkmybatis.service.impl;


import com.wulian.tkmybatis.entity.User;
import com.wulian.tkmybatis.mapper.UserMapper;
import com.wulian.tkmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}

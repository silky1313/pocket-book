package com.silky.pocketbook.service;

import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

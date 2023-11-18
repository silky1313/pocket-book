package com.silky.pocketbook.service;

import com.silky.pocketbook.POJO.User;
import com.silky.pocketbook.mapper.UserMapper;
import com.silky.pocketbook.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MyPasswordEncoder myPasswordEncoder;

    public int create(User user) {
        int success = userMapper.judgeUserExists(user.getUsername());
        if(success == 1) return 0;
        //TODO:对用户进行注册
        String encodePassword = myPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        return userMapper.insert(user);
    }

    public User findUserByUserName(String username) {
        return userMapper.selectByUsername(username);
    }
}

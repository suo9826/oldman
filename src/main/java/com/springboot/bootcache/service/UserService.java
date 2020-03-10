package com.springboot.bootcache.service;

import com.springboot.bootcache.bean.User;
import com.springboot.bootcache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ArrayList<User>  selectAll()
    {
        ArrayList<User> users = userMapper.selectAll();
        return users;
    }
    //通过username查询对应的user
    public User selectByname(String user_name)
    {
        User user1 = userMapper.selectByname(user_name);
       // System.out.println("select"+user.toString());
        return user1;
    }

    public void insert(User user)
    {
        userMapper.insert(user);
        System.out.println("service"+user.toString());
    }
}

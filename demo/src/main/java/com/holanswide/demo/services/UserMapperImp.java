package com.holanswide.demo.services;

import com.holanswide.demo.dao.UserMapper;
import com.holanswide.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/22
 */
@Service
public class UserMapperImp implements UserMapper {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryUserAll() {
        return userMapper.queryUserAll();
    }

    @Override
    public void updateUserByName(String name) {
        userMapper.updateUserByName(name);
    }
}

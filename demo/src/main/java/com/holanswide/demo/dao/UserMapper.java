package com.holanswide.demo.dao;

import com.holanswide.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：holan
 * @description：TODO
 * @date ：2022/9/22
 */
@Mapper
@Repository
public interface UserMapper {
    public List<User> queryUserAll();
    public void updateUserByName(@Param("name") String name);
}

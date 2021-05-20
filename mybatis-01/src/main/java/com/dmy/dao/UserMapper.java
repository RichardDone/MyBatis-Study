package com.dmy.dao;

import com.dmy.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部用户
    List<User> getUserList();

    //根据ID查询用户
    User getUserByID(int id);

    //insert一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User use);

    //删除用户
    int deleteUser(int id);

    //map的使用
    int addUser2(Map<String,Object> map);

    //模糊查询
    List<User> getUserLike(String value);
}

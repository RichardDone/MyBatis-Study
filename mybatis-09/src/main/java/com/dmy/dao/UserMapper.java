package com.dmy.dao;

import com.dmy.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    //根据id查询用户
    User queryUserByID(@Param("id") int id);

    //根据id修改用户信息
    int updateUser(User user);
}

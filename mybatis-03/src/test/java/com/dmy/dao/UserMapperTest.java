package com.dmy.dao;

import com.dmy.dao.UserMapper;
import com.dmy.pojo.User;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    //根据ID查询用户
    @Test
    public void getUserByID(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByID(1);
        System.out.println(user);

        sqlSession.close();
    }

}

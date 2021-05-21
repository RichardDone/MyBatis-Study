package com.dmy.dao;

import com.dmy.dao.UserMapper;
import com.dmy.pojo.User;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    //查询所有用户
    @Test
    public void getUserList(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();

        for (User user: userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    //根据ID查询用户
    @Test
    public void getUserByID(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByID(1);
        System.out.println(user);

        sqlSession.close();
    }

    //增删改需要提交事务
    //增加用户
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "王五", "123456"));
        if(res>0){
            System.out.println("插入成功！");
        }
        //提交实物
        sqlSession.commit();

        sqlSession.close();
    }

    //改
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4, "呵呵", "123123"));

        //提交实物
        sqlSession.commit();
        sqlSession.close();
    }

    //删
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        //提交实物
        sqlSession.commit();
        sqlSession.close();
    }
}

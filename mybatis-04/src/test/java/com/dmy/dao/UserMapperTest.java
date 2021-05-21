package com.dmy.dao;

import com.dmy.pojo.User;
import com.dmy.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    @Test
    //分页2
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);

        //通过java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.dmy.dao.UserMapper.getUserByRowBounds",null,rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    //分页
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);

        for (User user : userList) {
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

}

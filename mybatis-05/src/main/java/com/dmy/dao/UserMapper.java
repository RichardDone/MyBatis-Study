package com.dmy.dao;

import com.dmy.pojo.User;
import org.apache.ibatis.annotations.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserMapper {
    @Select("select * from mybatis.user")
    List<User> getUsers();

    // 方法存在多个参数，所有参数前加@Param
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int i);

    @Insert("insert into user(id, name, pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id =#{uid}")
    int deleteUser(@Param("uid") int id);
}

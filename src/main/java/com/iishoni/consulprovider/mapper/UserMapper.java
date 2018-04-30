package com.iishoni.consulprovider.mapper;

import com.iishoni.model.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> selectAll();

    @Select("select * from user where id = #{userId}")
    User selectById(Long userId);

    @Insert("insert into user values (" +
            "#{id}, #{username}, #{password}, #{nick}, #{age}, " +
            "#{birthday}, #{mobile}, #{balance}, #{lastLoginTime})")
    int insert(User user);

    @Update("update user set username = #{username}, password = #{password}, " +
            "nick = #{nick}, age = #{age}, birthday = #{birthday}, " +
            "mobile = #{mobile}, balance = #{balance}, lastLoginTime = #{lastLoginTime} " +
            "where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{userId}")
    int deleteById(Long userId);
}
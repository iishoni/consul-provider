package com.iishoni.consulprovider.mapper;

import com.iishoni.model.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {

    @Select("select * from admin")
    List<Admin> selectAll();

    @Select("select * from admin where id = #{adminId}")
    Admin selectById(Long adminId);

    @Insert({"insert into admin values (" +
            "#{id}, #{uname}, #{pwd}, #{nick}, #{avatar}, " +
            "#{state}, #{lastLoginTime}, #{createBy}, #{createTime}," +
            "#{updateBy}, #{updateTime})"})
    boolean insert(Admin admin);

    @Update("update admin set uname = #{uname}, pwd = #{pwd}, " +
            "nick = #{nick}, avatar = #{avatar}, state = #{state}, " +
            "last_login_time = #{lastLoginTime}, create_by = #{createBy}, create_time = #{createTime}, " +
            "update_by = #{updateBy}, update_time = #{updateTime} " +
            "where id = #{id}")
    boolean update(Admin admin);

    @Delete("delete from admin where id = #{adminId}")
    boolean deleteById(Long adminId);

}
package com.iishoni.service;

import com.github.pagehelper.PageHelper;
import com.iishoni.mapper.UserMapper;
import com.iishoni.model.User;
import com.iishoni.springboot.web.model.Page;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public Page<User> getUsersByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAll();
        return new Page<>(users, users.size());
    }

    public User getUserDetail(Long userId) {
        return userMapper.selectById(userId);
    }

    public Integer saveUser(User user) {
        return userMapper.insert(user);
    }

    public Integer updateUser(User user) {
        return userMapper.update(user);
    }

    public Integer deleteUser(Long userId) {
        return userMapper.deleteById(userId);
    }
}

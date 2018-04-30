package com.iishoni.consulprovider.web.controller;

import com.iishoni.api.Urls;
import com.iishoni.model.User;
import com.iishoni.consulprovider.service.UserService;
import com.iishoni.web.view.Page;
import com.iishoni.web.view.ResponseVo;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(Urls.User.ROOT)
@Api("用户接口")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("查询用户列表")
    @GetMapping(Urls.User.GET_USER_LIST)
    public ResponseVo<Page<User>> getUserList(
            @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<User> result = userService.getUsersByPage(pageNum, pageSize);
        return new ResponseVo<>(result);
    }

    @ApiOperation("查询用户信息")
    @GetMapping(Urls.User.GET_USER_INFO)
    public ResponseVo<User> getUserInfo(@PathVariable Long userId) {
        User result = userService.getUserDetail(userId);
        return new ResponseVo<>(result);
    }

    @ApiOperation("保存用户")
    @PostMapping(Urls.User.SAVE_USER)
    public ResponseVo saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseVo();
    }

    @ApiOperation("更新用户")
    @PutMapping(Urls.User.UPDATE_USER)
    public ResponseVo updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseVo();
    }

    @ApiOperation("删除用户")
    @DeleteMapping(Urls.User.DELETE_USER)
    public ResponseVo deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseVo();
    }
}

package com.iishoni.web.controller;

import com.iishoni.model.User;
import com.iishoni.service.UserService;
import com.iishoni.springboot.web.model.Page;
import com.iishoni.springboot.web.views.ResponseVo;
import com.iishoni.web.Urls;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(Urls.User.ROOT)
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(Urls.User.GET_USER_LIST)
    public ResponseVo<Page<User>> getUserList(
            @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<User> result = userService.getUsersByPage(pageNum, pageSize);
        return new ResponseVo<>(result);
    }

    @GetMapping(Urls.User.GET_USER_INFO)
    public ResponseVo<User> getUserInfo(@PathVariable Long userId) {
        User result = userService.getUserDetail(userId);
        return new ResponseVo<>(result);
    }

    @PostMapping(Urls.User.SAVE_USER)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping(Urls.User.UPDATE_USER)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping(Urls.User.DELETE_USER)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

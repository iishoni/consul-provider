package com.iishoni.consulprovider.web.controller;

import com.iishoni.api.Urls;
import com.iishoni.consulprovider.service.AdminService;
import com.iishoni.model.Admin;
import com.iishoni.web.view.Page;
import com.iishoni.web.view.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(Urls.Admin.ROOT)
@Api("用户接口")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ApiOperation("查询用户列表")
    @GetMapping(Urls.Admin.GET_ADMIN_LIST)
    public ResponseVo<Page<Admin>> getAdminList(
            @RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Page<Admin> result = adminService.getAdminsByPage(pageNum, pageSize);
        return new ResponseVo<>(result);
    }

    @ApiOperation("查询用户信息")
    @GetMapping(Urls.Admin.GET_ADMIN_INFO)
    public ResponseVo<Admin> getAdminInfo(@PathVariable Long adminId) {
        Admin result = adminService.getAdminDetail(adminId);
        return new ResponseVo<>(result);
    }

    @ApiOperation("保存用户")
    @PostMapping(Urls.Admin.SAVE_ADMIN)
    public ResponseVo saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return new ResponseVo();
    }

    @ApiOperation("更新用户")
    @PutMapping(Urls.Admin.UPDATE_ADMIN)
    public ResponseVo updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin);
        return new ResponseVo();
    }

    @ApiOperation("删除用户")
    @DeleteMapping(Urls.Admin.DELETE_ADMIN)
    public ResponseVo deleteAdmin(@PathVariable Long adminId) {
        adminService.deleteAdmin(adminId);
        return new ResponseVo();
    }
}

package com.iishoni.consulprovider.service;

import com.github.pagehelper.PageHelper;
import com.iishoni.consulprovider.mapper.AdminMapper;
import com.iishoni.model.Admin;
import com.iishoni.web.view.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Page<Admin> getAdminsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectAll();
        return new Page<>(admins, admins.size());
    }

    public Admin getAdminDetail(Long adminId) {
        return adminMapper.selectById(adminId);
    }

    public boolean saveAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    public boolean updateAdmin(Admin admin) {
        return adminMapper.update(admin);
    }

    public boolean deleteAdmin(Long adminId) {
        return adminMapper.deleteById(adminId);
    }
}

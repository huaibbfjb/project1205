package com.service.impl;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.entity.Admin;
import com.entity.User;
import com.service.AdminService;
import com.utils.Page;
import com.utils.Page2;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public int deleteUser(Integer userId) {
        return adminDao.deleteUser(userId);
    }

    @Override
    public List<User> queryAllUser() {
        return adminDao.queryAllUser();
    }

    @Override
    public Admin queryUserById(Integer userId) {
        return adminDao.queryUserById(userId);
    }

    @Override
    public Admin queryAdminByName(String username) {
        return adminDao.queryAdminByName(username);
    }

    @Override
    public Admin queryAdminByNameAndPassword(Admin admin) {
        return adminDao.queryAdminByNameAndPassword(admin);
    }

    @Override
    public Page<Admin> queryAdminByPage(int pageNo, int pageSize) {
        Page<Admin> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = adminDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo() - 1) * pageSize;
        //获取开始页码的分页数据
        List<Admin> items = adminDao.queryAdminByPage(begin, pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }


    @Override
    public Admin queryUserByUsername(String username) {
        return adminDao.queryUserByUsername(username);
    }

    @Override
    public Admin login(Admin admin) {
        return adminDao.queryAdminByNameAndPassword(admin);
    }

    public Page2<Admin> queryAdminByPage2() {
        Page2<Admin> page = new Page2<>();
        page.setCode(0);
        page.setMsg("");
        //求总记录数
        Integer pageTotalCount = adminDao.queryPageTotalCounts();
        page.setCount(pageTotalCount);
        page.setData(adminDao.queryAllAdmin());
        return page;
    }

    @Override
    public int updateUserColumnValue(Integer userId, String columnName, String columnValue) {
        return adminDao.updateUserColumnValue(userId,columnName,columnValue);
    }
}

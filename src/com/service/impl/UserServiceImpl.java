package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;
import com.utils.Page;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 15:31
 * 描述:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    public int register(User user) {
        return userDao.insertUser(user);
    }

    public User login(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    public int update(User user) {
        return userDao.updateUser(user);
    }

    public User queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    public User queryUserByName(String username){
        return userDao.queryUserByName(username);
    }

    public User queryUserByNameAndPassword(User user){
        return userDao.queryUserByNameAndPassword(user);
    }

    public Page<User> queryUserByPage(int pageNo, int pageSize) {
        Page<User> page = new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置页面大小
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = userDao.queryPageTotalCounts();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal =pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //求开始页码
        int begin = (page.getPageNo()-1)*pageSize;
        //获取开始页码的分页数据
        List<User> items=userDao.queryUserByPage(begin,pageSize);
        //设置数据
        page.setItems(items);
        return page;
    }


}
package com.dao;

import com.entity.User;

import java.util.List;

/**
 * 作者：林星源
 * 日期: 2020/12/9 11:13
 * 描述:
 */
public interface UserDao {
    int insertUser(User user);

    int updateUser(User user);

    //修改某个字段的电影信息
    int updateUserColumnValue(Integer userId,String columnName,String columnValue);

    int deleteUser(Integer userId);

    User queryUserById(Integer id);

    User queryUserByName(String username);

    User queryUserByNameAndPassword(User user);

    Integer queryPageTotalCounts();

    List<User> queryUserByPage(Integer pageNo, Integer pageSize);

    User queryUserByUsername(String username);

    User queryUserByTelephone(String telephone);

    List<User> queryAllUser();

    List<User> queryAllUser(String userName, String telephone, String qq, String email);
}

package com.choose.db.mybatis.dao;

import com.choose.db.mybatis.model.User;

/**
 * @className: UserMapper
 * @package: com.choose.db.mybatis.dao
 * @describe:
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 3:17
 */
public interface UserMapper {

    //访问读数据库
    User selectUserById(int id);

    //访问写数据库
    int addUser(User user);
}

package com.choose.db.service;

import com.choose.db.mybatis.model.User;

/**
 * @className: UserService
 * @package: com.choose.db.service
 * @describe:
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 3:18
 */
public interface UserService {

    //访问读数据库
    User selectUserById(int id);

    //访问写数据库
    int addUser(User user);
}

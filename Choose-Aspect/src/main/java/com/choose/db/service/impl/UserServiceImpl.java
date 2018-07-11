package com.choose.db.service.impl;

import com.choose.db.mybatis.dao.UserMapper;
import com.choose.db.mybatis.model.User;
import com.choose.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: UserServiceImpl
 * @package: com.choose.db.service.impl
 * @describe: 业务层
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 3:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //访问读数据库
    public User selectUserById(int id) {

        return userMapper.selectUserById(id);
    }

    //访问写数据库
    public int addUser(User user) {

        return userMapper.addUser(user);
    }
}

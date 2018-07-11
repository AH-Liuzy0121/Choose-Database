package com.choose.db.controller;

import com.choose.db.mybatis.model.User;
import com.choose.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @className: UserController
 * @package: com.choose.db.controller
 * @describe: 控制器
 * @auther: liuzhiyong
 * @date: 2018/7/11
 * @time: 下午 3:21
 */
@Controller
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select() {
        User user = userService.selectUserById(123);
        return user.toString();
    }

    //http://localhost:8080/user/add.do
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        User user = new User();
        user.setName("Jackson");
        user.setPassword("admin");
        int num = userService.addUser(user);
        return num == 1 ? "success" : "error";
    }
}

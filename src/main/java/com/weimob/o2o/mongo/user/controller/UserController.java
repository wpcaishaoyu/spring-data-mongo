package com.weimob.o2o.mongo.user.controller;

import com.weimob.o2o.mongo.user.entity.User;
import com.weimob.o2o.mongo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="mailto:yong.zhao@weimob.com">carl.zhao<a/>
 * @version 1.0.0
 * @see UserController
 * @since 1.0.0 2016-12-08
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "ok";
    }

    @RequestMapping("query")
    public List<User> findUserByCondition(@RequestBody User user){
        List<User> users = userService.findUserByCondition(user);
        return users;
    }

    @RequestMapping("page")
    public List<User> findUserByPage(@RequestBody User user){
//        MongoQueryUtils.
        List<User> users = userService.findUserByCondition(user);
        return users;
    }


}

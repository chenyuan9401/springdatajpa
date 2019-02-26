package com.yccc.controller;

import com.yccc.entity.User;
import com.yccc.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 查询
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userJPA.findAll();
    }

    /**
     * 添加更新
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(User user){
        return userJPA.save(user);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<User> delete(String id){
        userJPA.delete(id);
        return userJPA.findAll();
    }
}

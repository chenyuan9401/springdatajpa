package com.yccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 在创建拦截器之前我们需要添加初始化登录页面的转发配置，我们创建IndexController添加初始化登录、首页页面转发配置
 */
@Controller
@RequestMapping(value = "/user")
public class IndexController {

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view (){
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}


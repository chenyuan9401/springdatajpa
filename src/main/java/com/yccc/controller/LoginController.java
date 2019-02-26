package com.yccc.controller;

import com.yccc.entity.User;
import com.yccc.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录拦截器
 * 用户的实体以及JPA配置完成后我们再次打开LoginController，
 * 将UserJPA使用SpringBean的形式注入，然后完成简单的登录逻辑
 * @author  chenyuan
 *
 * 20180905
 */
@RestController
@RequestMapping(value = "/user")
public class LoginController {

    @Autowired
    private UserJPA userJPA;

    /**
     * 登录请求
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(User user, HttpServletRequest request) {
        boolean flag = true;
        String result = "登录成功";
        //1.根据用户名判断用户是否存在
        User userEntity = userJPA.findOne(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name") , user.getName()));
                return null;
            }
        });
        System.out.println("222333");
        //用户不存在
        if ( null == userEntity ) {
            System.out.println("22");
            flag = false;
            result = "用户不存在";
        }
        //2.判断用户名和密码是否正确
        //密码错误

        else if ((null == userEntity.getPwd() && "".equals(user.getPwd())) || !userEntity.getPwd().equals(user.getPwd())) {
            flag = false;
            result = "用户名密码不匹配";
        }
        //3.登录成功
        if (flag) {
            //将用户写进session
            request.getSession().setAttribute("_session_user", userEntity);
        }
        return  result;
    }
}


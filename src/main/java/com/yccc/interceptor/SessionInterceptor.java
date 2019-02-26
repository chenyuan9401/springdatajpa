package com.yccc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个名叫做SessionInterceptor的拦截器实体类，
 * 实现SpringMVC内部接口HandlerInterceptor，
 * 并且添加如果没有session状态直接跳转到/user/login_view地址也就是我们对应的login.jsp页面
 */
public class SessionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
            return true;
        }
        Object obj = request.getSession().getAttribute("_session_user");
        if (obj == null) {
            response.sendRedirect("/user/login_view");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

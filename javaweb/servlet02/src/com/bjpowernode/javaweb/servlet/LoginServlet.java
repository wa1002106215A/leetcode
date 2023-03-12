package com.bjpowernode.javaweb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoginServlet extends GenericServlet{
    @Override
    public void init(){
        System.out.println("init() execute!");
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("正在处理用户登录请求。。。");

        //想在LoginServlet子类中使用ServletConfig对象怎么办？
        ServletConfig config=this.getServletConfig();
        System.out.println("servletConfig"+":"+config);

    }
}

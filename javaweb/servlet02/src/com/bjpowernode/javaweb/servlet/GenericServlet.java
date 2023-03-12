package com.bjpowernode.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;

public abstract class GenericServlet implements Servlet {
    private ServletConfig servletConfig;

    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        this.init();

    }

    /**
     * 这个init()方法是供子类填写的
     */
    public void init() {


    }


    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }


    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

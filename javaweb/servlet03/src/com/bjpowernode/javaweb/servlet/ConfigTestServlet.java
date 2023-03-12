package com.bjpowernode.javaweb.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();

        //获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        //输出该对象
        out.println(config.toString());
        out.println("<br>");

        //获取<servlet-name>
        String servletName = config.getServletName();
        out.println("<servlet-name>" + servletName + "<servlet-name>");
        out.println("<br>");

        //获取web.xml文件中的初始化参数配置信息
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //遍历集合
        while (initParameterNames.hasMoreElements()) {
            String parameterName = initParameterNames.nextElement();//获取name
            String parameterVal = config.getInitParameter(parameterName);//通过name获取value
            out.println(parameterName + "=" + parameterVal);
            out.println("<br>" + "1");
        }

        out.println("<br>");
        //实际上获取一个Servlet对象的初始化参数，可以不用获取ServletConfig对象，可以直接通过this获取
        Enumeration<String> names = this.getInitParameterNames();
        //遍历集合
        while (names.hasMoreElements()) {
            String name = names.nextElement();//获取name
            String val = this.getInitParameter(name);//通过name获取value
            out.println(name + "=" + val);
            out.println("<br>" + "2");
        }


        //servletContext,获取全局参数
        ServletContext application = this.getServletContext();
        Enumeration<String> initParameter = application.getInitParameterNames();
        while (initParameter.hasMoreElements()) {
            String name = initParameter.nextElement();
            String value = application.getInitParameter(name);
            out.println(name + "=" + value);
            out.println("<br>" + "3");
        }

        User user = new User("wang", "123456");
        application.setAttribute("userObj", user);
        //取出来
        Object userObj = application.getAttribute("userObj");
        //输出到浏览器
        out.println(userObj + "<br>");

    }
}

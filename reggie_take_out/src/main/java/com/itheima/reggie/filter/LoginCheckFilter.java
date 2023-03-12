package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否登陆，登陆了才给访问
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {


    //调用Spring核心包的字符串匹配类,路径匹配器
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转一下,向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取uri
        String requestUrl = request.getRequestURI();
        //定义可以放行的请求url
        String[] urls = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login",
                "/doc.html",
                "/webjars/**",
                "/swagger-resources",
                "/v2/api-docs"
        };
        //判断这个路径是否直接放行
        Boolean cheakUrl = checkUrl(urls, requestUrl);
        //不需要处理直接放行
        if (cheakUrl){
            log.info("匹配到了{}",requestUrl);
            filterChain.doFilter(request, response);
            //放行完了直接结束就行
            return;
        }
        //判断用户已经登陆可以放行
        if(request.getSession().getAttribute("employee")!=null){
            log.info("已登录，用户id：{}",request.getSession().getAttribute("employee"));

            Long empId=(long)request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);


            filterChain.doFilter(request,response);
            return;
        }
        //判断用户已经登陆可以放行
        if(request.getSession().getAttribute("user")!=null){
            log.info("已登录，用户id：{}",request.getSession().getAttribute("user"));

            Long userId=(long)request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);


            filterChain.doFilter(request,response);
            return;
        }
        //没有登陆，跳转到登陆页面
        //前端有拦截器完成跳转页面，所以我们用输入流写个json来触发前端的拦截器完成跳转
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        log.info("拦截，交由前端跳转");
        return;

    }

    /**
     * @param urls 之前定义的可以放行的url地址数组
     * @param requestUrl 客户端打来的url地址
     * @return  返回值boolean值，true的话就是我们可以放行的目标
     */
    public boolean checkUrl(String []urls,String requestUrl){
        Boolean matchUrlResult = true;
        //遍历的同时调用PATH_MATCHER来对路径进行匹配
        for (String currUrl : urls) {
            matchUrlResult=PATH_MATCHER.match(currUrl, requestUrl);
            if (matchUrlResult){
                //匹配到了可以放行的路径，直接放行
                return true;
            }
        }
        //否则就是没有匹配到，不予放行
        return false;
    }


}

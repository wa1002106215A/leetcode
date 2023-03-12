package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.spi.SyncResolver;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//@WebServlet("/dept/add")
public class DeptAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");


        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;

        try {
            conn= DBUtil.getConnection();
            String sql="insert into dept(deptno,dname,loc) values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count= ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        if(count==1){
            //跳回list页面
            //转发
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            //重定向
            response.sendRedirect(""+request.getContextPath()+"/dept/list");
        }else {
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(""+request.getContextPath()+"/error.html");

        }

    }

}

package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/dept/delete")
public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String deptno = request.getParameter("deptno");

        Connection conn = null;
        PreparedStatement ps = null;
        int count=0;

        try {
            conn = DBUtil.getConnection();
            //开启事务（自动提交机制关闭）
            conn.setAutoCommit(false);
            String sql = "delete from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);
            //返回值count是影响了数据库多少条记录
            count = ps.executeUpdate();
            //事务提交
            conn.commit();


        } catch (SQLException e) {
            //遇到异常要回滚
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }finally {
            DBUtil.close(conn,ps,null);
        }

        //判断删除成功或者失败
        if(count==1){
            //跳回list页面
            //转发
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else {
            request.getRequestDispatcher("/error.html").forward(request,response);

        }

    }
}

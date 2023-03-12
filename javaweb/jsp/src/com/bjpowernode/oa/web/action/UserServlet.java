package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/user/login")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        boolean success=false;


        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select * from t_user where username=? and password=?";
            //编译sql
            ps=conn.prepareStatement(sql);
            //给？传值
            ps.setString(1,username);
            ps.setString(2,password);
            //执行sql
              rs= ps.executeQuery();

            if(rs.next()){
                success=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        if(success){
            //获取session对象
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/dept/list");

        }else {
            response.sendRedirect(request.getContextPath()+"/ ");

        }


    }
}

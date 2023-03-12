package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@WebServlet("/dept/detail")
public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("	<head>");
        out.print("		<meta charset='utf-8'>");
        out.print("		<title>部门详情</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1>部门详情</h1>");
        out.print("		<hr >");


        //获取部门编号
        String deptno = request.getParameter("deptno");

        //连接数据库，根据编号查询信息
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select dname,loc from dept where deptno=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, deptno);   //给第一个？赋值
            rs = ps.executeQuery();
            //只有一条数据
            if (rs.next()) {
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("部门编号："+deptno+"<br>");
                out.print("部门名称："+dname+"<br>");
                out.print("部门位置："+loc+"<br>");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }

        out.print("	<input type='button' value='后退' onclick='window.history.back()'/>");
        out.print("	</body>");
        out.print("</html>");
    }
}

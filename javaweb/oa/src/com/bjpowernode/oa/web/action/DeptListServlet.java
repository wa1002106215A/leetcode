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

//@WebServlet(value = "/dept/list")
public class DeptListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contextPath = request.getContextPath();

        //设置响应的内容类型以及字符集,防止乱码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset='utf-8'>");
        out.print("<title>部门列表页面</title>");

        out.print(" <script type='text/javascript'>");
        out.print("         function del(dno){");
        out.print("     if(window.confirm('亲，删了不可恢复哦！')){");
        out.print("         document.location.href = '" + contextPath + "/dept/delete?deptno=' + dno;");
        out.print("     }");
        out.print(" }");
        out.print(" </script>");

        out.print("</head>");
        out.print("<body>");
        out.print("		<h1 align='center'>部门列表</h1>");
        out.print("		<hr >");
        out.print("		<table border='1px' align='center' width='50%'>");
        out.print("			<tr>");
        out.print("				<th>序号</th>");
        out.print("				<th>部门编号</th>");
        out.print("				<th>部门名称</th>");
        out.print("				<th>操作</th>");
        out.print("			</tr>");

        //连接数据库，查询所有部门
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译的数据库操作对象
            String sql = "select deptno,dname,loc from dept";
            ps = conn.prepareStatement(sql);
            //执行SQL语句
            rs = ps.executeQuery();
            //处理结果集

            int i = 0;
            while (rs.next()) {
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("			<tr>");
                out.print("				<td>" + (++i) + "</td>");
                out.print("				<td>" + deptno + "</td>");
                out.print("				<td>" + dname + "</td>");
                out.print("				<td>");
                out.print("					<a href='javascript:void(0)' onclick='del(" + deptno + ")'>删除</a>");
                out.print("					<a href='" + contextPath + "/dept/edit?deptno=" + deptno + "'>修改</a>");
                out.print("					<a href='" + contextPath + "/dept/detail?deptno=" + deptno + "'>详情</a>");
                out.print("				</td>");
                out.print("			</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }


        out.print("		</table>");
        out.print("		<hr >");
        out.print("		<a href='" + contextPath + "/add.html'>新增部门</a>");
        out.print("	</body>");
        out.print("</html>");

    }
}

package com.bjpowernode.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 */
public class DBUtil {

    //静态变量，在类加载时执行，并且是有顺序的
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");  //绑定属性资源文件
    //根据属性资源文件的key获取value
    private static String driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String password = bundle.getString("password");

    static {
        //注册驱动(只需要注册一次，放在静态代码框当中，DBUtil类加载的时候执行)
        try {
            //"com.mysql.jdbc.Driver"是连接数据库的驱动，不能写死
            //Class.forName("com.mysql.jdbc.Driver");

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取数据库连接对象
     * return conn连接对象；
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        //获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //注册驱动
    //获取连接
    //获取数据库操作对象  conn.preparedStatement   (一行代码，不需要封装)
    //执行SQL语句   (一行代码，不需要封装)
    //处理查询结果集  (不需要封装)
    //释放资源

    /**
     * 释放资源
     * @param conn  连接对象
     * @param ps    数据库操作对象
     * @param rs    结果集对象
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

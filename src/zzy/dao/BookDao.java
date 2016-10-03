package zzy.dao;

import java.sql.*;
import java.util.*;

public class BookDao {
    private Statement stmt;
    private String sql;
    //构造方法，进行数据库的连接
    private BookDao() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            // 一个Connection代表一个数据库连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "zzyadmin");
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            stmt = conn.createStatement();
            /*this.sql = "SELECT * FROM bookdb.book";
            ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
            System.out.println("学号\t姓名");
            while (rs.next()) {
                System.out
                        .println(rs.getString("ISBN") + "\t" + rs.getString("Title"));// 如果返回的是int类型可以用getInt()
            }*/
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //接下来是对应于
}

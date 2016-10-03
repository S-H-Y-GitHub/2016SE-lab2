package zzy.dao;

import zzy.model.*;

import java.sql.*;
import java.util.*;

public class AuthorDao {
    private Statement stmt;

    //构造方法，进行数据库的连接
    public AuthorDao() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "zzyadmin");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("MySQL连接错误");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("MySQL驱动程序错误");
            e.printStackTrace();
        }
    }

    public void search(String name) {
        String sql1 = "select * from author " + "where Name like '%" + name + "%';";
        try {
            ResultSet rs1 = stmt.executeQuery(sql1);
            if (rs1.next()) {
                Author author = new Author();
                author.setAuthorID(rs1.getInt("AuthorID"));
                author.setName(name);
                author.setAge(rs1.getInt("Age"));
                author.setCountry(rs1.getString("Country"));
                String sql2 = "select * from book " + "where AuthorID="
                        + author.getAuthorID() + ";";
                ResultSet rs2 = stmt.executeQuery(sql2);
                while (rs2.next()) {
                    Book book = new Book();
                    book.setISBN(rs2.getString("ISBN"));
                    book.setTitle(rs2.getString("Title"));
                    book.setPublisher(rs2.getString("Publisher"));
                    book.setPublishDate(rs2.getDate("PublishDate"));
                    book.setPrice(rs2.getFloat("Price"));
                    book.setAuthorID(rs2.getInt("AuthorID"));
                    //TODO 结果已经生成好了，需要返回回去
                }
                return;
            } else {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}
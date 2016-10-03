package zzy.dao;

import zzy.model.*;

import java.sql.*;
import java.util.*;

public class BookDao {
    private Statement stmt;

    //构造方法，进行数据库的连接
    public BookDao(){
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
    //获取书籍信息
    public ArrayList<Book> getAll(){
        ArrayList<Book> books;
        books = new ArrayList<Book>();
        String sql = "select * from book;";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Book book = new Book();
                book.setISBN(rs.getString("ISBN"));
                book.setTitle(rs.getString("Title"));
                book.setAuthorID(rs.getInt("AuthorID"));
                book.setPublisher(rs.getString("Publisher"));
                book.setPublishDate(rs.getDate("PublishDate"));
                book.setPrice(rs.getFloat("Price"));
                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("MySQL查询错误");
            e.printStackTrace();
        }
        return books;
    }
    //删除已经存在的书籍
    public Boolean remove(String ISBN) {
        String sql = "delete from book " + "where ISBN=" + ISBN + ";";
        try {
            if (stmt.executeUpdate(sql) == 1) {
                return Boolean.TRUE;
            } else
                return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }
}

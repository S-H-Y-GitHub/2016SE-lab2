package zzy.dao;

import zzy.model.Book;

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

    public ArrayList<Book> getBooks(){
        ArrayList<Book> books;
        books = new ArrayList<Book>();
        String sql = "select * from book";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Book book = new Book();
                book.setISBN(rs.getInt("ISBN"));

                books.add(book);
            }
        } catch (SQLException e) {
            System.err.println("MySQL查询错误");
            e.printStackTrace();
        }

        return books;
    }
}

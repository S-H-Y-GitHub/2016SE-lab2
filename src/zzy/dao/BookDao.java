package zzy.dao;

import zzy.model.*;
import java.sql.*;
import java.util.*;

/**
 * 处理与Book相关的所有数据库操作
 */
public class BookDao
{
	private Statement stmt;
	
	/**构造方法，进行数据库的连接，连接失败时会跳转到error500.html*/
	public BookDao()
	{
		Connection conn;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "zzyadmin");
			stmt = conn.createStatement();
		}
		catch (SQLException e)
		{
			System.err.println("MySQL连接错误@zzy.dao.BookDao.BookDao");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.err.println("MySQL驱动程序错误@zzy.dao.BookDao.BookDao");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取全部书籍信息
	 * @return 包含数据库中所有书籍的数组
	 */
	public ArrayList<Book> getAll()
	{
		String sql = "select * from book;";
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getFloat("Price"));
				books.add(book);
			}
			return books;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.getAll");
			e.printStackTrace();
			return books;
		}
	}
	/**
	 * 基于书名搜索书籍（本次实验没有使用）
	 * @param Title 书籍的名字
	 * @return 找到的书籍数组
	 */
	public ArrayList<Book> search(String Title)
	{
		String sql = "select * from book where Title='" + "';";
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getFloat("Price"));
				books.add(book);
			}
			return books;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.search");
			e.printStackTrace();
			return books;
		}
	}
	/**
	 * 基于ISBN提取一本书
	 * @param isbn 要提取书籍的ISBN
	 * @return 提取到的书籍，如果没有这本书则返回null
	 */
	public Book get(String isbn)
	{
		String sql = "select * from book where ISBN='" + isbn + "';";
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
			{
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getFloat("Price"));
				return book;
			}
			else
				return null;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.get");
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 删除已经存在的书籍
	 * @param ISBN 要删除书籍的ISBN
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean remove(String ISBN)
	{
		String sql = "delete from book where ISBN='" + ISBN + "';";
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (Exception e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.removeBook");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	/**
	 * 获取一个作者的所有书籍
	 * @param authorid 这位作者的ID
	 * @return 这位作者的所有著作
	 */
	public ArrayList<Book> getByAuthor(int authorid)
	{
		String sql = "select * from book WHERE AuthorID =" + authorid + ";";
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				Book book = new Book();
				book.setISBN(rs.getString("ISBN"));
				book.setTitle(rs.getString("Title"));
				book.setAuthorID(rs.getInt("AuthorID"));
				book.setPublisher(rs.getString("Publisher"));
				book.setPublishDate(rs.getDate("PublishDate"));
				book.setPrice(rs.getFloat("Price"));
				books.add(book);
			}
			return books;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.getByAuthor");
			e.printStackTrace();
			return books;
		}
	}
	/**
	 * 添加一本书
	 * @param book 要加入数据库的书籍对象
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean add(Book book)
	{
		String sql = "INSERT INTO book(ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES(" +
				book.getISBN() + ",'" + book.getTitle() + "'," + book.getAuthorID() + ",'" +
				book.getPublisher() + "','" + book.getPublishDate() + "'," + book.getPrice() + ");";
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.add");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	/**
	 * 更新书籍信息
	 * @param book 要更新的书籍对象，通过isbn确定书籍，然后将数据库中这本书的信息用book对象中的数据代替
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean update(Book book)
	{
		String sql = "update book set Title='" + book.getTitle() + "',AuthorID=" + book.getAuthorID() + ",Publisher='"
				+ book.getPublisher() + "',PublishDate='" + book.getPublishDate() + "',Price=" + book.getPrice()
				+ " where ISBN=" + book.getISBN();
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.update");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	/**
	 * 确定数据库中是否有指定ISBN的书籍存在
	 * @param isbn 指定的ISBN
	 * @return 存在中为true，不存在则为false
	 */
	public Boolean hasISBN(String isbn)
	{
		String sql = "select * from book where ISBN='" + isbn + "';";
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.BookDao.hasISBN");
			e.printStackTrace();
			return false;
		}
	}
}

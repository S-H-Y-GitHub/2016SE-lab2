package zzy.dao;

import zzy.model.*;
import java.sql.*;

public class AuthorDao
{
	private Statement stmt;
	
	//构造方法，进行数据库的连接
	public AuthorDao()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "zzyadmin");
			stmt = conn.createStatement();
		}
		catch (SQLException e)
		{
			System.err.println("MySQL连接错误");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.err.println("MySQL驱动程序错误");
			e.printStackTrace();
		}
	}
	public Author get(int AuthorID)
	{
		String sql = "select * from author WHERE AuthorID =" + AuthorID + ";";
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
			{
				Author author = new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setName(rs.getString("Name"));
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
				return author;
			}
			else
				return null;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误");
			e.printStackTrace();
			return null;
		}
	}
	public Author search(String name)
	{
		String sql1 = "select * from author where Name like '%" + name + "%';";
		try
		{
			ResultSet rs1 = stmt.executeQuery(sql1);
			if (rs1.next())
			{
				Author author = new Author();
				author.setAuthorID(rs1.getInt("AuthorID"));
				author.setName(name);
				author.setAge(rs1.getInt("Age"));
				author.setCountry(rs1.getString("Country"));
				return author;
			}
			else
				return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
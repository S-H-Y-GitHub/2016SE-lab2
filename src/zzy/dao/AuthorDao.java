package zzy.dao;

import zzy.model.*;

import java.security.PublicKey;
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
	//根据作者的ID返回这个作者的所有相关信息
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
	//基于作者的姓名进行搜索
	public Author search(String name)
	{
		String sql1 = "select * from author where Name = '" + name + "';";
		try
		{
			ResultSet rs = stmt.executeQuery(sql1);
			if (rs.next())
			{
				Author author = new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setName(name);
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
	//向数据库中增加作者
	public Boolean add(Author author)
	{
		String sql = "INSERT INTO author (AuthorID, Name, Age, Country) VALUES ("
				+ author.getAuthorID() + ",'" + author.getName() + "'," + author.getAge()
				+ ",'" + author.getCountry() + "');";
		try
		{
			if (stmt.executeUpdate(sql) == 1)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	//更新作者信息
	public Boolean update(Author author)
	{
		String sql = "UPDATE author set Name='" + author.getName() + "',Country='" + author.getCountry()
				+ "',Age=" + author.getAge() + " WHERE AuthorID=" + author.getAuthorID() + ";";
		try
		{
			if (stmt.executeUpdate(sql) == 1)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
}
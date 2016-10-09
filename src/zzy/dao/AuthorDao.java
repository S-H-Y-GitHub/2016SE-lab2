package zzy.dao;

import zzy.model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * 处理与Author相关的所有数据库操作
 */
public class AuthorDao
{
	private Statement stmt;
	
	/**构造方法，进行数据库的连接，连接失败时会跳转到error500.html*/
	public AuthorDao()
	{
		Connection conn;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://wxvjstmagsgz.rds.sae.sina.com.cn:10433/bookdb", "root", "zzyadmin");
			stmt = conn.createStatement();
		}
		catch (SQLException e)
		{
			System.err.println("MySQL连接错误@zzy.dao.AuthorDao.AuthorDao");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.err.println("MySQL驱动程序错误@zzy.dao.AuthorDao.AuthorDao");
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据作者的ID返回这个作者的所有相关信息
	 * @param AuthorID 作者的ID
	 * @return 作者对象，如果失败则返回null
	 */
	public Author get(int AuthorID)
	{
		String sql = "select * from author WHERE AuthorID=" + AuthorID + ";";
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
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.get");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 基于作者的姓名在数据库中进行搜索
	 * @param name 作者的姓名
	 * @return ArrayList(Author)，保存了所有以name为名的作者的信息，若没有以name为名的作者则返回空数组
	 */
	public ArrayList<Author> search(String name)
	{
		String sql1 = "select * from author where Name = '" + name + "';";
		ArrayList<Author> authors = new ArrayList<>();
		try
		{
			ResultSet rs = stmt.executeQuery(sql1);
			while (rs.next())
			{
				Author author = new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setName(name);
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
				authors.add(author);
			}
			return authors;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.search");
			e.printStackTrace();
			return authors;
		}
	}
	/**
	 * 向数据库中增加作者
	 * @param author 要添加的Author对象
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean add(Author author)
	{
		String sql = "INSERT INTO author (AuthorID, Name, Age, Country) VALUES ("
				+ author.getAuthorID() + ",'" + author.getName() + "'," + author.getAge()
				+ ",'" + author.getCountry() + "');";
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.add");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	/**
	 * 更新作者信息
	 * @param author 要更新的Author对象
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean update(Author author)
	{
		String sql = "UPDATE author set Name='" + author.getName() + "',Country='" + author.getCountry()
				+ "',Age=" + author.getAge() + " WHERE AuthorID=" + author.getAuthorID() + ";";
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.update");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	/**
	 * 基于作者的ID查找作者是否存在
	 * @param AuthorID 作者的ID
	 * @return 作者存在则为true，不存在则为false
	 */
	public Boolean hasAuthorID(int AuthorID)
	{
		String sql = "select * from author WHERE AuthorID=" + AuthorID + ";";
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			return rs.next();
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.hasAuthorID");
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 返回所有作者的信息
	 * @return 包含数据库中所有作者的数组
	 */
	public ArrayList<Author> getAll()
	{
		String sql = "select * from author;";
		ArrayList<Author> authors = new ArrayList<>();
		try
		{
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				Author author = new Author();
				author.setAuthorID(rs.getInt("AuthorID"));
				author.setName(rs.getString("Name"));
				author.setAge(rs.getInt("Age"));
				author.setCountry(rs.getString("Country"));
				authors.add(author);
			}
			return authors;
		}
		catch (SQLException e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.getAll");
			e.printStackTrace();
			return authors;
		}
	}
	/**
	 * 删除一个作者
	 * @param authorID 要删除的作者的ID
	 * @return 操作成功则为true，失败则为false
	 */
	public Boolean remove(int authorID)
	{
		String sql = "delete from author where AuthorID='" + authorID + "';";
		try
		{
			if (stmt.executeUpdate(sql) > 0)
				return Boolean.TRUE;
			else
				return Boolean.FALSE;
		}
		catch (Exception e)
		{
			System.err.println("MySQL查询错误@zzy.dao.AuthorDao.remove");
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
}
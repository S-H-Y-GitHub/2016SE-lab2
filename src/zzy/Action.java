package zzy;

import zzy.model.*;
import zzy.dao.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport
{
	private Book book;
	private Author author;
	private ArrayList<Book> books;
	private ArrayList<Author> authors;
	private BookDao bookdao = new BookDao();
	private AuthorDao authordao = new AuthorDao();
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublishDate;
	private String dateStr;
	private float Price;
	private String Name;
	private int Age;
	private String Country;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	//显示所有书籍的概况
	public String listBook()
	{
		books = bookdao.getAll();
		return SUCCESS;
	}
	//显示所有作者的概况
	public String listAuthor()
	{
		authors = authordao.getAll();
		return SUCCESS;
	}
	//显示一本书的相关信息
	public String showBookDetails()
	{
		book = bookdao.get(ISBN);
		authors = authordao.getAll();// XXX 权宜之计，浪费时间
		if (null != book)
		{
			dateStr = sdf.format(book.getPublishDate());
			author = authordao.get(book.getAuthorID());
			if (null != author)
				return SUCCESS;
			else
				return ERROR;
		}
		else
			return ERROR;
	}
	/**
	 * 显示作者信息，需提供作者的AuthorID
	 *
	 * @return 包含作者信息的author对象，包含他的所有作品的数组books
	 */
	public String showAuthorDetails()
	{
		author = authordao.get(AuthorID);
		books = bookdao.getByAuthor(AuthorID);
		return "success";
	}
	//删除一本书
	public String removeBook()
	{
		bookdao.remove(ISBN);
		return SUCCESS;
	}
	//删除一个作者
	public String removeAuthor()
	{
		if (!bookdao.getByAuthor(AuthorID).isEmpty())
			return ERROR;
		//else //needless
		authordao.remove(AuthorID);
		return SUCCESS;
	}
	//搜索作者姓名 // FIXME: 2016/10/6 多个作者同名怎么办？
	public String searchAuthor()
	{
		author = authordao.search(Name);
		if (null != author)
		{
			books = bookdao.getByAuthor(author.getAuthorID());
			if (null != books)
				return SUCCESS;
			else
				return ERROR;
		}
		else
			return ERROR;
	}
	/**
	 * 基于收到的表单添加一本新书，会对表单数据有效性进行检验
	 */
	public String addBook()
	{
		book = formToBook();
		if (book != null && !bookdao.hasISBN(book.getISBN()) && bookdao.add(book))
			return SUCCESS;
		else
			return ERROR;
	}
	/**
	 * 基于收到的表单添加一位作者，会对表单数据有效性进行检验
	 */
	public String addAuthor()
	{
		author = formToAuthor();
		if (author != null && !authordao.hasAuthorID(author.getAuthorID()) && authordao.add(author))
			return SUCCESS;
		else
			return ERROR;
	}
	/**
	 * 基于收到的表单修改书籍信息,会对表单数据有效性进行检验
	 */
	public String editBook()
	{
		book = formToBook();
		if (book != null && bookdao.hasISBN(book.getISBN()) && bookdao.update(book))
			return SUCCESS;
		else
			return ERROR;
	}
	/**
	 * 基于收到的表单修改作者信息,会对表单数据有效性进行检验
	 */
	public String editAuthor()
	{
		author = formToAuthor();
		if (author != null && authordao.hasAuthorID(author.getAuthorID()) && authordao.update(author))
			return SUCCESS;
		else
			return ERROR;
	}
	
	/**
	 * 将收到的表单信息转换为book对象，需准备好表单信息。注意没有验证ISBN是否已经存在，请在使用时按照需求加入，但是验证了AuthorID的存在
	 *
	 * @return 表单完善时为Book对象，表单非法时为null
	 */
	private Book formToBook()
	{
		try
		{
			if (AuthorID != 0 && Price != 0 && dateStr != null && Publisher != null && ISBN != null && Title != null
					&& Publisher.matches(".{1,45}")
					&& ISBN.matches("\\d{13}")
					&& Title.matches(".{1,45}")
					&& dateStr.matches("\\d{4}-\\d{2}-\\d{2}")
					&& authordao.hasAuthorID(AuthorID))
			{
				Book book = new Book();
				book.setAuthorID(AuthorID);
				book.setPrice(Price);
				book.setPublishDate(java.sql.Date.valueOf(dateStr));
				book.setPublisher(Publisher);
				book.setISBN(ISBN);
				book.setTitle(Title);
				return book;
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
	
	/**
	 * 将收到的表单信息转换为Author对象，需准备好表单信息。注意没有验证AuthorID是否已经存在，请在使用时按照需求加入
	 *
	 * @return 表单完善时为Author对象，表单非法时为null
	 */
	private Author formToAuthor()
	{
		if (AuthorID != 0 && Age != 0 && Country != null && Name != null
				&& Country.matches(".{1,45}") && Name.matches(".{1,45}") && Age < 175)
		{
			Author author = new Author();
			author.setAuthorID(AuthorID);
			author.setAge(Age);
			author.setCountry(Country);
			author.setName(Name);
			return author;
		}
		else
			return null;
	}
	
	public Book getBook() {return book;}
	public void setBook(Book book) {this.book = book;}
	
	public ArrayList<Book> getBooks() {return books;}
	public void setBooks(ArrayList<Book> books) {this.books = books;}
	
	public String getISBN() {return ISBN;}
	public void setISBN(String ISBN) {this.ISBN = ISBN;}
	
	public Author getAuthor() {return author;}
	public void setAuthor(Author author) {this.author = author;}
	
	public String getName() {return Name;}
	public void setName(String name) {this.Name = name;}
	
	public String getTitle() {return Title;}
	public void setTitle(String Title) {this.Title = Title;}
	
	public int getAuthorID() {return AuthorID;}
	public void setAuthorID(int AuthorID) {this.AuthorID = AuthorID;}
	
	public String getPublisher() {return Publisher;}
	public void setPublisher(String publisher) {Publisher = publisher;}
	
	public Date getPublishDate() {return PublishDate;}
	public void setPublishDate(Date publishDate) {PublishDate = publishDate;}
	
	public float getPrice() {return Price;}
	public void setPrice(float price) {Price = price;}
	
	public int getAge() {return Age;}
	public void setAge(int age) {Age = age;}
	
	public String getCountry() {return Country;}
	public void setCountry(String country) {Country = country;}
	
	public ArrayList<Author> getAuthors() {return authors;}
	public void setAuthors(ArrayList<Author> authors) {this.authors = authors;}
	
	public String getDateStr() {return dateStr;}
	public void setDateStr(String dateStr) {this.dateStr = dateStr;}
}
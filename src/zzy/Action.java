package zzy;

import zzy.model.*;
import zzy.dao.*;
import java.sql.Date;
import java.util.ArrayList;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport
{
	private Book book;
	private Author author;
	private ArrayList<Book> books;
	private BookDao bookdao = new BookDao();
	private AuthorDao authordao = new AuthorDao();
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublishDate;
	private float Price;
	private String Name;
	private int Age;
	private String Country;
	
	//显示所有书籍的概况
	public String list()
	{
		books = bookdao.getAll();
		return SUCCESS;
	}
	//显示一本书的相关信息
	public String showDetails()
	{
		book = bookdao.get(ISBN);
		if (null != book)
		{
			author = authordao.get(book.getAuthorID());
			if (null != author)
				return SUCCESS;
			else
				return ERROR;
		}
		else
			return ERROR;
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
		if (bookdao.getByAuthor(AuthorID).isEmpty())
			return ERROR;
		//else
		authordao.remove(AuthorID);
		return SUCCESS;
	}
	//搜索作者姓名
	public String searchAuthor()
	{
		author = authordao.search(Name);
		if(null != author)
		{
			books = bookdao.getByAuthor(author.getAuthorID());
			if(null != books)
				return SUCCESS;
			else
				return ERROR;
		}
		else
			return ERROR;
	}
	//添加一本新书，需要规定author和book
	public String addBook()
	{
		if((!authordao.hasAuthorID(author.getAuthorID())) )
		{
			if((authordao.add(author)) && (bookdao.add(book)))
				return SUCCESS;
			else
				return ERROR;
		}
		else
		{
			if (bookdao.add(book))
				return SUCCESS;
			else
				return ERROR;
		}
	}
	//添加一个作者
	public String addAuthor()
	{
		if(authordao.add(author))
			return SUCCESS;
		else
			return ERROR;
	}
	//
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
}
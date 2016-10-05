package zzy;

import zzy.model.*;
import zzy.dao.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport
{
	private Book book;
	private Author author;
	private ArrayList<Book> books;
	private BookDao bookdao = new BookDao();
	private AuthorDao authordao = new AuthorDao();
	private String isbn;
	private String name;
	//显示所有书籍的概况
	public String list()
	{
		books = bookdao.getAll();
		return SUCCESS;
	}
	//显示一本书的相关信息
	public String showDetails()
	{
		book = bookdao.get(isbn);
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
	public String remove()
	{
		bookdao.remove(isbn);
		return SUCCESS;
	}
	//搜索作者姓名
	public String searchAuthor()
	{
		author = authordao.search(name);
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
	
	public Book getBook() {return book;}
	public void setBook(Book book) {this.book = book;}
	
	public ArrayList<Book> getBooks() {return books;}
	public void setBooks(ArrayList<Book> books) {this.books = books;}
	
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	
	public Author getAuthor() {return author;}
	public void setAuthor(Author author) {this.author = author;}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
}
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
	
	public String list()
	{
		books = bookdao.getAll();
		return SUCCESS;
	}
	
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
	
	public String remove()
	{
		bookdao.remove(isbn);
		return SUCCESS;
	}
	
	public String searchAuthor()
	{
		author = authordao.search(name);
		if(null != author)
		{
			books = bookdao.getBooksByAuthor(author.getAuthorID());
			if(null != books)
				return SUCCESS;
			else
				return ERROR;
		}
		else
			return ERROR;
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
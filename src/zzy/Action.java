package zzy;

import zzy.model.*;
import zzy.dao.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 本次实验中的所有Action
 */
public class Action extends ActionSupport
{
	private Book book;
	private Author author;
	private ArrayList<Book> books;
	private ArrayList<Author> authors;
	private HashMap<Author,ArrayList<Book>> bookOfAuthor = new HashMap<>();
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
	private String errMsg="JUST_ERROR_NO_WHY";
	
	/**显示所有书籍的概况，结果保存在books数组中*/
	public String listBook()
	{
		books = bookdao.getAll();
		return SUCCESS;
	}
	/**显示所有作者的概况，结果保存在authors数组中*/
	public String listAuthor()
	{
		authors = authordao.getAll();
		return SUCCESS;
	}
	/**显示一本书的所有相关信息。需要规定ISBN来选择特定的一本书。执行完成后书籍信息保存在book对象中，格式化后的出版日期保存在dateStr中，书籍作者的信息保存在author对象中。为了支持修改功能，会将数据库中全部作者存到authors数组中*/
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
			{
				errMsg = "数据库中没有AuthorID为"+book.getAuthorID()+"的作者";
				return ERROR;
			}
		}
		else
		{
			errMsg = "数据库中没有ISBN为"+ISBN+"的书籍";
			return ERROR;
		}
	}
	/**显示作者信息，需提供这位作者的AuthorID。执行完成后会得到包含作者信息的author对象和包含他的所有作品的数组books*/
	public String showAuthorDetails()
	{
		author = authordao.get(AuthorID);
		if(author != null)
		{
			books = bookdao.getByAuthor(AuthorID);
			return SUCCESS;
		}
		else
		{
			errMsg = "数据库中没有AuthorID为"+AuthorID+"的作者";
			return ERROR;
		}
	}
	/**删除一本书，需要提供这本书的ISBN*/
	public String removeBook()
	{
		if(bookdao.remove(ISBN))
			return SUCCESS;
		else
			return ERROR;
	}
	/**删除一个作者*/
	public String removeAuthor()
	{
		if (!bookdao.getByAuthor(AuthorID).isEmpty())
		{
			errMsg = "这位作者有著作留存";
			return ERROR;
		}
		//else //needless
		authordao.remove(AuthorID);
		return SUCCESS;
	}
	/**
	 * 根据作者姓名搜索作者和所有作品。需要提供作者的姓名。
	 * 执行完成后会得到一个HashMap，key为Author对象，value为Books数组。
	 */
	public String searchAuthor()
	{
		authors = authordao.search(Name);
		for (Author author:authors)
		{
			books = bookdao.getByAuthor(author.getAuthorID());
			bookOfAuthor.put(author,books);
		}
		return SUCCESS;
	}
	/**基于收到的表单添加一本新书，会对表单数据有效性进行检验*/
	public String addBook()
	{
		book = formToBook();
		if (book != null && !bookdao.hasISBN(book.getISBN()) && bookdao.add(book))
			return SUCCESS;
		else
		{
			errMsg = "输入数据不合法";
			return ERROR;
		}
	}
	/**基于收到的表单添加一位作者，会对表单数据有效性进行检验*/
	public String addAuthor()
	{
		author = formToAuthor();
		if (author != null && !authordao.hasAuthorID(author.getAuthorID()) && authordao.add(author))
			return SUCCESS;
		else
		{
			errMsg = "输入数据不合法";
			return ERROR;
		}
	}
	/**基于收到的表单修改书籍信息,会对表单数据有效性进行检验*/
	public String editBook()
	{
		book = formToBook();
		if (book != null && bookdao.hasISBN(book.getISBN()) && bookdao.update(book))
			return SUCCESS;
		else
		{
			errMsg = "输入数据不合法";
			return ERROR;
		}
	}
	/**基于收到的表单修改作者信息,会对表单数据有效性进行检验*/
	public String editAuthor()
	{
		author = formToAuthor();
		if (author != null && authordao.hasAuthorID(author.getAuthorID()) && authordao.update(author))
			return SUCCESS;
		else
		{
			errMsg = "输入数据不合法";
			return ERROR;
		}
	}
	
	/**
	 * 将收到的表单信息转换为book对象，需准备好表单信息。注意没有验证ISBN是否已经存在，请在使用时按照需求加入，但是验证了AuthorID的存在
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
	
	public HashMap<Author, ArrayList<Book>> getBookOfAuthor() {return bookOfAuthor;}
	public void setBookOfAuthor(HashMap<Author, ArrayList<Book>> bookOfAuthor) {this.bookOfAuthor = bookOfAuthor;}
	
	public String getErrMsg() {return errMsg;}
	public void setErrMsg(String errMsg) {this.errMsg = errMsg;}
}
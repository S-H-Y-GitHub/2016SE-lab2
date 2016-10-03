package zzy;

import zzy.model.*;
import zzy.dao.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport {

    private Book book;
    private ArrayList <Book> books;
    private BookDao dao = new BookDao();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public String load() {
        book = dao.getBook(isbn);
        return SUCCESS;
    }

    public String list() {
        books = dao.getBooks();
        return SUCCESS;
    }

    public String store() {
        dao.storeBook(book);
        return SUCCESS;
    }

    public String remove() {
        if(null != isbn) {
            dao.removeBook(isbn);
        } else {
            dao.removeBooks(isbns);
        }
        return SUCCESS;
    }
}
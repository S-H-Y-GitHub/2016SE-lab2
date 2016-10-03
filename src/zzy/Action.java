package zzy;

import zzy.model.*;
import zzy.dao.*;
import java.util.*;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport {

    private Book book;
    private ArrayList <Book> books;
    private BookDao bookdao = new BookDao();
    private AuthorDao authordao = new AuthorDao();
    private String isbn;
    private String name;

    public String list() {
        books = bookdao.getAll();
        return SUCCESS;
    }

    public String remove() {
        bookdao.remove(isbn);
        return SUCCESS;
    }

    public String searchAuthor() {
        authordao.search(name);
        return SUCCESS;
    }



    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
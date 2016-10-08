package zzy.model;

import java.sql.Date;

/**
 * 保存一个Book的所有信息
 */
public class Book
{
	private String ISBN;
	private String Title;
	private int AuthorID;
	private String Publisher;
	private Date PublishDate;
	private float Price;
	
	public void setISBN(String ISBN) {this.ISBN = ISBN;}
	public String getISBN() {return ISBN;}
	
	public void setTitle(String Title) {this.Title = Title;}
	public String getTitle() {return Title;}
	
	public void setAuthorID(int AuthorID) {this.AuthorID = AuthorID;}
	public int getAuthorID() {return AuthorID;}
	
	public void setPublisher(String Publisher) {this.Publisher = Publisher;}
	public String getPublisher() {return Publisher;}
	
	public void setPublishDate(Date PublishDate) {this.PublishDate = PublishDate;}
	public Date getPublishDate() {return PublishDate;}
	
	public void setPrice(float Price) {this.Price = Price;}
	public float getPrice() {return Price;}
}
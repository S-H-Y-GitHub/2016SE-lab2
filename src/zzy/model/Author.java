package zzy.model;

public class Author
{
	private int AuthorID;
	private String Name;
	private int Age;
	private String Country;
	
	public void setAuthorID(int AuthorID) {this.AuthorID = AuthorID;}
	public int getAuthorID() {return AuthorID;}
	
	public void setName(String Name) {this.Name = Name;}
	public String getName() {return Name;}
	
	public void setAge(int Age) {this.Age = Age;}
	public int getAge() {return Age;}
	
	public void setCountry(String Country) {this.Country = Country;}
	public String getCountry() {return Country;}
}
package model;

public class Book {
  private String title;
  private String author;
  private String isbn;
  private Category category;
  private int publicationYear;
  private boolean isBorrowed;


//Constructor
  public Book(String title,String author,String isbn,Category category,int publicationYear,boolean isBorrowed){
      this.title=title;
      this.author=author;
      this.category=category;
      this.isbn=isbn;this.publicationYear=publicationYear;
      this.isBorrowed=isBorrowed;
  }
//Setter
  public void borrowBook() {
      this.isBorrowed=true;
  }

  public void returnBook() {
      this.isBorrowed=false;
  }
//Getter
  public String  getTitle()           {return this.title;}
  public String  getAuthor()          {return this.author;}
  public String  getIsbn()            {return this.isbn;}
  public Integer getPublicationYear() {return this.publicationYear;}
  public Category getCategory()       {return this.category;}
  public boolean getIsBorrowed()      {return this.isBorrowed;}
}

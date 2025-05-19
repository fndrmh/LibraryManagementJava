package model;

public class Book {
  private String title;
  private String author;
  private String isbn;
  private int publicationYear;
  private boolean isBorrowed;

  public void borrowBook() {
      this.isBorrowed=true;
  }

  public void returnBook() {
      this.isBorrowed=false;
  }

  public void getDetails(String title,String author,String isbn,int publicationYear,boolean  isBorrowed) {
      this.title=title;
      this.author=author;
      this.isbn=isbn;
      this.publicationYear=publicationYear;
      this.isBorrowed=isBorrowed;
 }
}

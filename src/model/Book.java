package model;

import jsonlib.JSONSerializable;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class Book implements JSONSerializable {
  private String title;
  private String author;
  private String isbn;
  private int publicationYear;
  private boolean isBorrowed;

  // Constructor
  public Book(String title, String author, String isbn, int publicationYear, boolean isBorrowed) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.publicationYear = publicationYear;
    this.isBorrowed = isBorrowed;
  }

  // Setter
  public void borrowBook() {
    this.isBorrowed = true;
  }

  public void returnBook() {
    this.isBorrowed = false;
  }

  // Getter
  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public Integer getPublicationYear() {
    return this.publicationYear;
  }

  public boolean getIsBorrowed() {
    return this.isBorrowed;
  }

  @Override
  public JSONObject serialize() {
    JSONDict result = new JSONDict();

    result.put("class", JSONObject.fromString("Book"));
    result.put("title", JSONObject.fromString(title));
    result.put("author", JSONObject.fromString(author));
    result.put("isbn", JSONObject.fromString(isbn));
    result.put("publicationYear", JSONObject.fromNumber(publicationYear));
    result.put("isBorrowed", JSONObject.fromBoolean(isBorrowed));

    return result;
  }

  public static Book deserialize(JSONDict json) {
    return new Book(json.getString("title"), json.getString("author"), json.getString("isbn"),
        json.getInteger("publicationYear"), json.getBoolean("isBorrowed"));
  }
}

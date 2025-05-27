package model;

import jsonlib.JSONSerializable;
import jsonlib.JSONSerializableFactory;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class Book implements JSONSerializable {
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

  public Category getCategory() {
    return this.category;
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
    result.put("category", category.serialize());
    result.put("publicationYear", JSONObject.fromNumber(publicationYear));
    result.put("isBorrowed", JSONObject.fromBoolean(isBorrowed));

    return result;
  }

  public static Book deserialize(JSONDict json) {
    Category category = (Category) JSONSerializableFactory.deserialize((JSONDict) json.get("category"));
    return new Book(json.getString("title"), json.getString("author"), json.getString("isbn"),
        category, json.getInteger("publicationYear"), json.getBoolean("isBorrowed"));
  }

}

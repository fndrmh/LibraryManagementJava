package model;

public class Category {
  private String name;
  private String description;
//Constructor
  public Category(String name,String description){
      this.name=name;
      this.description=description;
  }
//Getter
  public String getName() {
      return this.name;
  }
  public String getDescription() {
      return this.description;
  }
}

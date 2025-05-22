package model;

import jsonlib.JSONSerializable;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class Category implements JSONSerializable {
  private String name;
  private String description;

  // Constructor
  public Category(String name, String description) {
    this.name = name;
    this.description = description;
  }

  // Getter
  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  @Override
  public JSONObject serialize() {
    // TODO: Implemented method 'serialize' for Category
    throw new UnsupportedOperationException("Unimplemented method 'serialize' for Category");
  }


  public static Category deserialize(JSONDict json) {
    // TODO: Implemented method 'deserialize' for Category
    throw new UnsupportedOperationException("Unimplemented method 'deserialize' for Category");
  }
}

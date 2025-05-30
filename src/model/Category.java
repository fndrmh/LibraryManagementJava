package model;

import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class Category extends BaseModel {
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
  public String toString() {
    return String.format("%s (%s)", name, description);
  }

  @Override
  public String getDisplayName() {
    return name;
  }

  @Override
  public JSONObject serialize() {
    JSONDict result = new JSONDict();

    result.put("class", JSONObject.fromString("Category"));
    result.put("name", JSONObject.fromString(name));
    result.put("description", JSONObject.fromString(description));

    return result;
  }

  public static Category deserialize(JSONDict json) {
    return new Category(json.getString("name"), json.getString("description"));
  }
}

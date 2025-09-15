package model;

import jsonlib.types.JSONObject;

import java.util.Objects;

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
    return this.name;
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

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Category))
      return false;

    Category other = (Category) obj;

    return this.name.equals(other.name) && this.description.equals(other.description);
  }
}

package jsonlib.types;

import jsonlib.JSONSerializable;

import java.util.HashMap;
import java.util.Map;

public class JSONDict extends JSONObject {
  public Map<JSONString, JSONObject> value;

  public JSONDict() {
    this.value = new HashMap<>();
  }

  public <T extends JSONSerializable> JSONDict(Map<String, T> value) {
    this.value = new HashMap<>();

    if (value == null)
      return;

    for (Map.Entry<String, T> entry : value.entrySet()) {
      this.value.put(new JSONString(entry.getKey()), entry.getValue().serialize());
    }
  }

  public void put(JSONString key, JSONObject value) {
    this.value.put(key, value);
  }

  public void put(String key, JSONObject value) {
    this.value.put(new JSONString(key), value);
  }

  public JSONObject get(String key) {
    return this.value.get(new JSONString(key));
  }

  public String getString(String key) {
    JSONObject obj = this.get(key);
    if (!(obj instanceof JSONString))
      throw new IllegalArgumentException(String.format("dict[%s] is not an string", key));

    JSONString jsonString = (JSONString) obj;
    return jsonString.getValue();
  }

  public int getInteger(String key) {
    JSONObject obj = this.get(key);
    if (!(obj instanceof JSONNumber))
      throw new IllegalArgumentException(String.format("dict[%s] is not a number", key));

	JSONNumber<Integer> jsonNumber = (JSONNumber<Integer>) obj;
    return jsonNumber.getValue();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");

    for (Map.Entry<JSONString, JSONObject> entry : value.entrySet()) {
      sb.append(entry.getKey().toString());
      sb.append(": ");
      sb.append(entry.getValue().toString());
      sb.append(", ");
    }

    // ignore the last ", "
    sb.delete(sb.length() - 2, sb.length());

    sb.append("}");
    return sb.toString();
  }
}

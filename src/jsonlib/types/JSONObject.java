package jsonlib.types;

import jsonlib.JSONSerializable;

import java.util.List;
import java.util.Map;

public abstract class JSONObject {
  public static JSONObject fromString(String data) {
    return new JSONString(data);
  }

  public static <T extends Number> JSONObject fromNumber(T data) {
    return new JSONNumber<T>(data);
  }

  public static <T extends JSONSerializable> JSONObject fromList(List<T> data) {
    return new JSONList(data);
  }

  public static <T extends JSONSerializable> JSONObject fromDict(Map<String, T> data) {
    return new JSONDict(data);
  }

  @Override
  public abstract String toString();
}

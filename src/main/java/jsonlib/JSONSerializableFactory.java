package jsonlib;

import jsonlib.types.JSONDict;

import java.util.HashMap;
import java.util.Map;

public class JSONSerializableFactory {
  private static final Map<String, Class<? extends JSONSerializable>> typeRegistry = new HashMap<>();

  public static void registerType(String type, Class<? extends JSONSerializable> clazz) {
    typeRegistry.put(type, clazz);
  }

  public static JSONSerializable deserialize(JSONDict json) {
    if (json == null) {
      throw new IllegalArgumentException("Invalid JSON");
    }

    String type = json.getString("class");
    Class<? extends JSONSerializable> clazz = typeRegistry.get(type);
    if (clazz == null)
      throw new IllegalArgumentException("Unknown type: " + type);

    try {
      java.lang.reflect.Method deserializeMethod = clazz.getMethod("deserialize", JSONDict.class);
      return (JSONSerializable) deserializeMethod.invoke(null, json);
    } catch (Exception e) {
      throw new IllegalArgumentException("Failed to deserialize: " + type, e);
    }
  }
}

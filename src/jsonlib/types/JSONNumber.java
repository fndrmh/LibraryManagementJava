package jsonlib.types;

public class JSONNumber<T extends Number> extends JSONObject {
  public T value;

  public JSONNumber(T value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

  public T getValue() {
    return this.value;
  }
}

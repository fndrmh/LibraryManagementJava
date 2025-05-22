package jsonlib.types;

public class JSONString extends JSONObject {
  public String value;

  public JSONString(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("\"%s\"", value);
  }

  @Override
  public int hashCode() {
    return this.value.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof JSONString))
      return false;

    JSONString other = (JSONString) obj;

    return this.value.equals(other.getValue());
  }
}

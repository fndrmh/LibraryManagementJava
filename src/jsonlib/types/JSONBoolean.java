package jsonlib.types;

public class JSONBoolean extends JSONObject {
  private boolean value;

  public JSONBoolean(boolean value) {
    this.value = value;
  }

  public boolean getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    return value ? "true" : "false";
  }

  @Override
  public int hashCode() {
    return this.value ? 1 : 0;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof JSONBoolean))
      return false;

    JSONBoolean other = (JSONBoolean) obj;

    return this.value == other.value;
  }
}

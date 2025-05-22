package jsonlib.types;

import jsonlib.JSONSerializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSONList extends JSONObject implements Iterable<JSONObject> {
  public List<JSONObject> value;

  public JSONList() {
    this.value = new ArrayList<>();
  }

  public <T extends JSONSerializable> JSONList(List<T> value) {
    this.value = new ArrayList<>();

    if (value == null)
      return;

    for (T item : value) {
      this.value.add(item.serialize());
    }
  }

  public void add(JSONObject data) {
    this.value.add(data);
  }

  public <T extends JSONSerializable> void add(T data) {
    this.value.add(data.serialize());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < value.size(); i++) {
      sb.append(value.get(i).toString());
      if (i + 1 < value.size())
        sb.append(", ");
    }
    sb.append("]");

    return sb.toString();
  }

  @Override
  public Iterator<JSONObject> iterator() {
    return value.iterator();
  }
}

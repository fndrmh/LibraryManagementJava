package model;

import jsonlib.JSONSerializable;

public abstract class BaseModel implements JSONSerializable {
  public abstract String getDisplayName();

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(Object obj);
}

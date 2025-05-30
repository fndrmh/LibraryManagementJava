package model;

import jsonlib.JSONSerializable;

public abstract class BaseModel implements JSONSerializable {
  public abstract String getDisplayName();
}

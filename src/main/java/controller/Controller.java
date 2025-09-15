package controller;

import view.UserInterface;
import model.Library;

public interface Controller {
  public void setUserInterface(UserInterface ui);
  public void setLibrary(Library library);

  default public void setInputData(Object data) {}
}

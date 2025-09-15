package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Library;
import view.UserInterface;

public class LibraryController implements Controller {
  private Library library;
  private UserInterface userInterface;

  @FXML
  private Button manageUsersButton;
  @FXML
  private Button manageBooksButton;
  @FXML
  private Button loansButton;
  @FXML
  private Button reportsButton;

  @FXML
  private void handleManageUsersClick() {
    try {
      userInterface.loadPage("/manage_users.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleManageBooksClick() {
    try {
      userInterface.loadPage("/manage_books.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleLoansClick() {
    try {
      userInterface.loadPage("/loans.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleExitClick() {
    Platform.exit();
  }

  @FXML
  private void handleAddStudentClick() {
    try {
      userInterface.loadPage("/add_student.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleListAllStudentsClick() {
    try {
      userInterface.loadPage("/list_all_students.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleListAllBooksClick() {
    try {
      userInterface.loadPage("/list_all_books.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleAddBookClick() {
    try {
      userInterface.loadPage("/add_book.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @FXML
  private void handleCheckOutBooksClick() {
    try {
      userInterface.loadPage("/check_out_books.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  @FXML
  private void handleReturnBooksClick() {
    try {
      userInterface.loadPage("/return_books.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleBackButton() {
    try {
      userInterface.loadPage("/main_menu.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setUserInterface(UserInterface ui) {
    this.userInterface = ui;
  }

  @Override
  public void setLibrary(Library library) {
    this.library = library;
  }
}

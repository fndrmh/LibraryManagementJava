package controller;

import java.io.IOException;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import model.Book;
import model.Library;
import model.Student;
import view.UserInterface;

public class CheckOutBooksController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private TextField idField;
  @FXML
  private TextField isbnField;
  @FXML Label errorLabel;

  @FXML
  public void initialize() {
    UnaryOperator<TextFormatter.Change> filter = change -> {
      String newText = change.getControlNewText();
      return newText.matches("\\d*") ? change : null;
    };

    TextFormatter<String> formatter = new TextFormatter<>(filter);
    idField.setTextFormatter(formatter);
  }
  
  @FXML
  private void handleOpenBookList() {
    try {
      userInterface.loadPage("/list_all_books.fxml");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleCancelButton(ActionEvent event) {
    try {
      Button source = (Button) event.getSource();
      userInterface.loadPage(source.getUserData().toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleBorrowBookClick() throws IOException {
    String studentID = idField.getText().trim();
    String bookISBN = isbnField.getText().trim();

    boolean fieldsEmpty = studentID.isEmpty() || bookISBN.isEmpty();
    if (fieldsEmpty) {
      errorLabel.setText("Cannot proceed — one or more fields are empty.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    Student student = this.library.searchStudentById(studentID);
    if (student == null) {
      errorLabel.setText("Student not found.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    Book book = this.library.searchBookByISBN(bookISBN);
    if (book == null || book.getIsBorrowed()) {
      errorLabel.setText("Invalid or unavailable book.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    errorLabel.setVisible(false);
    errorLabel.setManaged(false);

    library.borrowBook(book, student);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("✅ Book borrowed successfully.");
    alert.showAndWait();

    userInterface.loadPage("/loans.fxml");
  }

  @Override
  public void setInputData(Object data) {
    if (data instanceof Book)
      isbnField.setText(((Book) data).getIsbn());
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

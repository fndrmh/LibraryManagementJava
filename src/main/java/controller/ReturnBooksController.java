package controller;

import java.io.IOException;
import java.util.List;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Book;
import model.Library;
import model.Student;
import view.UserInterface;

public class ReturnBooksController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private TextField idField;
  @FXML Label errorLabel;

  @FXML
  private TableView<Book> borrowedBooksTable;
  @FXML
  private TableColumn<Book, String> isbnColumn;
  @FXML
  private TableColumn<Book, String> titleColumn;
  @FXML
  private TableColumn<Book, Void> returnColumn;

  private String currentStudentID;


  @FXML
  public void initialize() {
    UnaryOperator<TextFormatter.Change> filter = change -> {
      String newText = change.getControlNewText();
      return newText.matches("\\d*") ? change : null;
    };

    TextFormatter<String> formatter = new TextFormatter<>(filter);
    idField.setTextFormatter(formatter);

    isbnColumn.setPrefWidth(150);
    titleColumn.setPrefWidth(250);
    returnColumn.setPrefWidth(150);

    isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

    returnColumn.setCellFactory(param -> new TableCell<>() {
      private final Button returnButton = new Button("Return");
      {
        returnButton.setOnAction(event -> {
          Book book = getTableView().getItems().get(getIndex());
          handleReturnBook(book);
        });
      }

      @Override
      protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
          setGraphic(null);
        } else {
          setGraphic(returnButton);
        }
      }
    });
  }

  private void handleReturnBook(Book book) {
    this.library.returnBook(book);
    List<Book> updatedBooks = this.library.getBorrowedBooksByStudent(currentStudentID);
    borrowedBooksTable.getItems().setAll(updatedBooks);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("✅ Book returned successfully.");
    alert.showAndWait();
  }

  @FXML
  private void handleBackButton(ActionEvent event) {
    try {
      Button source = (Button) event.getSource();
      userInterface.loadPage(source.getUserData().toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleSearchButton(ActionEvent event) {
    String studentID = idField.getText().trim();

    if (studentID.isEmpty()) {
      errorLabel.setText("Cannot proceed — one or more fields are empty.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      borrowedBooksTable.getItems().clear();
      studentID = null;
      return;
    }

    Student student = this.library.searchStudentById(idField.getText());
    if (student == null) {
      errorLabel.setText("Student not found.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      borrowedBooksTable.getItems().clear();
      studentID = null;
      return;
    }

    List<Book> borrowedBooks = this.library.getBorrowedBooksByStudent(studentID);
    if (borrowedBooks.isEmpty()) {
      errorLabel.setText("This student hasn't borrowed any book.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      borrowedBooksTable.getItems().clear();
      studentID = null;
      return;
    }

    errorLabel.setVisible(false);
    errorLabel.setManaged(false);

    currentStudentID = studentID;
    borrowedBooksTable.getItems().setAll(borrowedBooks);
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

package controller;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Book;
import model.Library;
import view.UserInterface;

public class ListAllBooksController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private TableView<Book> bookTable;
  @FXML
  private TableColumn<Book, String> isbnColumn, titleColumn, authorColumn, categoryColumn, yearColumn;

  private ObservableList<Book> masterBookList = FXCollections.observableArrayList();
  private FilteredList<Book> filteredBooks;

  @FXML
  private GridPane detailPanel;

  private Book selectedBook;
  @FXML private Label isbnLabel;
  @FXML private Label titleLabel;
  @FXML private Label authorLabel;
  @FXML private Label categoryLabel;
  @FXML private Label yearLabel;
  @FXML private Label availableLabel;

  @FXML private ComboBox<String> searchByComboBox;
  @FXML private TextField searchField;
  @FXML private Button clearSearchButton; 
  @FXML private Button borrowButton;

  public void initialize() {
    searchByComboBox.getItems().addAll("ISBN", "Title", "Author", "Category", "Publication Year");
    searchByComboBox.setValue("ISBN");

    searchField.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
    searchByComboBox.valueProperty().addListener((obs, oldVal, newVal) -> applyFilter());

    bookTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
      if (newSel == null)
        return;

      detailPanel.setVisible(true);
      detailPanel.setManaged(true);

      selectedBook = (Book) newSel;

      borrowButton.setVisible(true);
      borrowButton.setManaged(true);

      if (selectedBook.getIsBorrowed()) {
        borrowButton.setVisible(false);
        borrowButton.setManaged(false);
      }

      isbnLabel.setText(selectedBook.getIsbn());
      titleLabel.setText(selectedBook.getTitle());
      authorLabel.setText(selectedBook.getAuthor());
      categoryLabel.setText(selectedBook.getCategory().toString());
      yearLabel.setText(selectedBook.getPublicationYear().toString());
      availableLabel.setText(selectedBook.getIsAvailable().toString());
    });
  }

  
  private void applyFilter() {
    String searchBy = searchByComboBox.getValue();
    String searchText = searchField.getText().toLowerCase();

    if (!searchBy.isEmpty()) {
      clearSearchButton.setVisible(true);
      clearSearchButton.setManaged(true);
    } else {
      clearSearchButton.setVisible(true);
      clearSearchButton.setManaged(true);
    }

    filteredBooks.setPredicate(book -> {
      if (searchText == null || searchText.isEmpty()) {
        return true; // Show all
      }

      switch (searchBy) {
        case "ISBN":
          return book.getIsbn().toLowerCase().contains(searchText);
        case "Title":
          return book.getTitle().toLowerCase().contains(searchText);
        case "Author":
          return book.getAuthor().toLowerCase().contains(searchText);
        case "Category":
          return book.getCategory().toString().toLowerCase().contains(searchText);
        case "Publication Year":
          return book.getPublicationYear().toString().toLowerCase().contains(searchText);
        default:
          return true;
      }
    });
  }

  public void postInit() {
    isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
    titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
    categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    yearColumn.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));

    masterBookList.setAll(library.getBooks());
    filteredBooks = new FilteredList<>(masterBookList, p -> true);

    bookTable.setItems(filteredBooks);
  }

  @FXML
  private void handleClearSearchClick() {
    searchField.setText("");
    clearSearchButton.setVisible(false);
    clearSearchButton.setManaged(false);
  }

  @FXML
  private void handleBorrowButtonClick() {
    try {
      if (selectedBook.getIsBorrowed())
        return;

      userInterface.loadPage("/check_out_books.fxml", selectedBook);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void handleRemoveButtonClick() {
    String bookTitle = titleLabel.getText();
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirm Delete");
    alert.setHeaderText("Remove Book");
    alert.setContentText("Are you sure you want to remove book " + bookTitle + "?");

    Optional<ButtonType> result = alert.showAndWait();

    if (result.isPresent() && result.get() == ButtonType.OK) {
      library.removeBook(isbnLabel.getText());
      masterBookList.setAll(library.getBooks());

      detailPanel.setVisible(false);
      detailPanel.setManaged(false);

      selectedBook = null;

      Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
      infoAlert.setTitle("Book Removed");
      infoAlert.setHeaderText(null);
      infoAlert.setContentText("Book \"" + bookTitle + "\" was successfully removed.");
      infoAlert.showAndWait();
    }
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

	@Override
	public void setUserInterface(UserInterface ui) {
    this.userInterface = ui;
	}

	@Override
	public void setLibrary(Library library) {
    this.library = library;
    postInit();
	}
}

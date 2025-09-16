package controller;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.GraduateStudent;
import model.Library;
import model.Student;
import model.UndergraduateStudent;
import view.UserInterface;

public class ListAllStudentsController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private TableView<Student> studentTable;
  @FXML
  private TableColumn<Student, String> idColumn, firstNameColumn, lastNameColumn, majorColumn;

  private ObservableList<Student> masterStudentList = FXCollections.observableArrayList();
  private FilteredList<Student> filteredStudents;

  @FXML
  private GridPane detailPanel;

  @FXML private Label idLabel;
  @FXML private Label firstNameLabel;
  @FXML private Label lastNameLabel;
  @FXML private Label typeLabel;
  @FXML private Label majorLabel;
  @FXML private Label enrollmentYearLabel;
  @FXML private Label supervisorLabel;
  @FXML private Label thesisTitleLabel;

  @FXML private HBox enrollmentYearBox;
  @FXML private HBox supervisorBox;
  @FXML private HBox thesisTitleBox;

  @FXML private ComboBox<String> searchByComboBox;
  @FXML private TextField searchField;
  @FXML private Button clearSearchButton; 
  @FXML private Button removeButton;

  public void initialize() {
    searchByComboBox.getItems().addAll("ID", "Major", "First Name", "Last Name");
    searchByComboBox.setValue("ID");

    searchField.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
    searchByComboBox.valueProperty().addListener((obs, oldVal, newVal) -> applyFilter());

    studentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
      detailPanel.setVisible(true);
      detailPanel.setManaged(true);

      Student selectedStudent = (Student) newSel;

      idLabel.setText(selectedStudent.getStudentId());
      firstNameLabel.setText(selectedStudent.getFirstName());
      lastNameLabel.setText(selectedStudent.getLastName());
      majorLabel.setText(selectedStudent.getMajor());
      typeLabel.setText(selectedStudent.getType());

      enrollmentYearBox.setVisible(false);
      enrollmentYearBox.setManaged(false);

      supervisorBox.setVisible(false);
      supervisorBox.setManaged(false);
      
      thesisTitleBox.setVisible(false);
      thesisTitleBox.setManaged(false);

      if (selectedStudent instanceof UndergraduateStudent) {
        UndergraduateStudent undergrad = (UndergraduateStudent) selectedStudent;
        enrollmentYearLabel.setText(String.valueOf(undergrad.getEnrollmentYear()));
        enrollmentYearBox.setVisible(true);
        enrollmentYearBox.setManaged(true);
      } else if (selectedStudent instanceof GraduateStudent) {
        GraduateStudent grad = (GraduateStudent) selectedStudent;
        supervisorLabel.setText(grad.getSupervisor());
        thesisTitleLabel.setText(grad.getThesisTitle());

        supervisorBox.setVisible(true);
        supervisorBox.setManaged(true);

        thesisTitleBox.setVisible(true);
        thesisTitleBox.setManaged(true);

      }
    });

    Image image = new Image(getClass().getResourceAsStream("/icons/trash-can.png"));
    ImageView imageView = new ImageView(image);

    imageView.setFitWidth(16);
    imageView.setFitHeight(16);

    removeButton.setGraphic(imageView);
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

    filteredStudents.setPredicate(student -> {
      if (searchText == null || searchText.isEmpty()) {
        return true; // Show all
      }

      switch (searchBy) {
        case "ID":
          return student.getStudentId().toLowerCase().contains(searchText);
        case "Major":
          return student.getMajor().toLowerCase().contains(searchText);
        case "First Name":
          return student.getFirstName().toLowerCase().contains(searchText);
        case "Last Name":
          return student.getLastName().toLowerCase().contains(searchText);
        default:
          return true;
      }
    });
  }

  // we need this function because initialize will be called before setLibrary
  // therefore library is null. so we use this function to init the list after
  // the libray got set.
  public void postInit() {
    idColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
    firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

    masterStudentList.setAll(library.getAllStudents());
    filteredStudents = new FilteredList<>(masterStudentList, p -> true);

    studentTable.setItems(filteredStudents);
  }

  @FXML
  private void handleClearSearchClick() {
    searchField.setText("");
    clearSearchButton.setVisible(false);
    clearSearchButton.setManaged(false);
  }

  @FXML
  private void handleRemoveButtonClick() {
    String studentFullName = firstNameLabel.getText() + " " + lastNameLabel.getText();
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirm Delete");
    alert.setHeaderText("Remove Student");
    alert.setContentText("Are you sure you want to remove student " + studentFullName + "?");

    Optional<ButtonType> result = alert.showAndWait();

    if (result.isPresent() && result.get() == ButtonType.OK) {
      library.removeStudent(idLabel.getText());
      masterStudentList.setAll(library.getAllStudents());

      detailPanel.setVisible(false);
      detailPanel.setManaged(false);

      Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
      infoAlert.setTitle("Student Removed");
      infoAlert.setHeaderText(null);
      infoAlert.setContentText("Student \"" + studentFullName + "\" was successfully removed.");
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

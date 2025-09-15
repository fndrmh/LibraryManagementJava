package controller;

import java.io.IOException;
import java.time.Year;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import view.UserInterface;
import model.Library;
import model.Student;
import model.UndergraduateStudent;
import model.GraduateStudent;

public class AddStudentController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private ToggleGroup studentTypeGroup;
  @FXML
  private RadioButton undergradRadio;
  @FXML
  private RadioButton gradRadio;

  @FXML
  private GridPane gradContainer;
  @FXML
  private GridPane undergradContainer;

  @FXML
  private ComboBox<Integer> yearComboBox;

  @FXML
  private TextField studentIDField;
  @FXML
  private TextField firstNameField;
  @FXML
  private TextField lastNameField;
  @FXML
  private TextField majorField;

  @FXML
  private TextField supervisorField;
  @FXML
  private TextField thesisTitleField;

  @FXML
  private Label errorLabel;

  @FXML
  private Button addButton;

  @FXML
  public void initialize() {
    studentTypeGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
      if (newToggle != null) {
        RadioButton selected = (RadioButton) newToggle;
        String selectedType = selected.getText();

        if ("Undergraduate".equals(selectedType)) {
          undergradContainer.setVisible(true);
          undergradContainer.setManaged(true);
          gradContainer.setVisible(false);
          gradContainer.setManaged(false);
        } else if ("Graduate".equals(selectedType)) {
          undergradContainer.setVisible(false);
          undergradContainer.setManaged(false);
          gradContainer.setVisible(true);
          gradContainer.setManaged(true);
        }
      }
    });

    UnaryOperator<TextFormatter.Change> filter = change -> {
      String newText = change.getControlNewText();
      return newText.matches("\\d*") ? change : null;
    };

    TextFormatter<String> formatter = new TextFormatter<>(filter);
    studentIDField.setTextFormatter(formatter);

    int currentYear = Year.now().getValue();
    for (int y = currentYear; y >= currentYear - 50; y--) {
      yearComboBox.getItems().add(y);
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
  private void handleAddStudentClick() throws IOException {
    String studentID = studentIDField.getText().trim();
    String firstName = firstNameField.getText().trim();
    String lastName = lastNameField.getText().trim();
    String major = majorField.getText().trim();

    Integer enrollmentYear = yearComboBox.getValue();
    String supervisor = supervisorField.getText().trim();
    String thesisTitle = thesisTitleField.getText().trim();

    RadioButton selectedStudentType = (RadioButton) studentTypeGroup.getSelectedToggle();

    boolean commonFieldsEmpty = firstName.isEmpty()
      || lastName.isEmpty()
      || studentID.isEmpty()
      || major.isEmpty();

    boolean typeSpecificEmpty = false;
    if (selectedStudentType.getText().equals("Undergraduate")) {
      typeSpecificEmpty = enrollmentYear == null;
    } else if (selectedStudentType.getText().equals("Graduate")) {
      typeSpecificEmpty = thesisTitle.isEmpty()
        || supervisor.isEmpty();
    }
    
    if (commonFieldsEmpty || typeSpecificEmpty) {
      errorLabel.setText("Cannot proceed — one or more fields are empty.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    if (this.library.searchStudentById(studentID) != null) {
      errorLabel.setText("This student ID already exists.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    errorLabel.setVisible(false);
    errorLabel.setManaged(false);

    Student student;
    if (selectedStudentType.getText().equals("Undergraduate"))
      student = new UndergraduateStudent(studentID, firstName, lastName, major, enrollmentYear);
    else if (selectedStudentType.getText().equals("Graduate"))
      student = new GraduateStudent(studentID, firstName, lastName, major, supervisor, thesisTitle);
    else
      return;

    this.library.addStudent(student);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("✅ Student added successfully.");
    alert.showAndWait();

    userInterface.loadPage("/manage_users.fxml");
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

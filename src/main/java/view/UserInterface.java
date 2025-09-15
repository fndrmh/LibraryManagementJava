package view;

import java.io.IOException;

import controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jsonlib.JSONSerializableFactory;
import model.Book;
import model.Category;
import model.GraduateStudent;
import model.Library;
import model.Loan;
import model.UndergraduateStudent;

public class UserInterface {
  private Stage primaryStage;

  private Library library;

  public UserInterface(Stage stage) {
    this.primaryStage = stage;
    
    this.library = new Library();
    JSONSerializableFactory.registerType("UndergraduateStudent", UndergraduateStudent.class);
    JSONSerializableFactory.registerType("GraduateStudent", GraduateStudent.class);
    JSONSerializableFactory.registerType("Book", Book.class);
    JSONSerializableFactory.registerType("Category", Category.class);
    JSONSerializableFactory.registerType("Loan", Loan.class);
    library.loadData();
  }

  public void start() throws IOException {
    loadMainMenu();
  }

  public void loadMainMenu() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/main_menu.fxml"));
    Parent root = loader.load();

    Controller controller = loader.getController();
    controller.setUserInterface(this);

    Scene scene = new Scene(root, 600, 700);
    scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

    primaryStage.setScene(scene);
    
    primaryStage.setTitle("Library Management System");
    primaryStage.show();
  }

  public void loadPage(String pageName) throws IOException {
    loadPage(pageName, null);
  }


  public void loadPage(String pageName, Object inputData) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(pageName));
    Parent newPage = loader.load();

    Controller controller = loader.getController();
    controller.setUserInterface(this);
    controller.setLibrary(library);

    if (inputData != null)
      controller.setInputData(inputData);

    primaryStage.getScene().setRoot(newPage);
  }
}

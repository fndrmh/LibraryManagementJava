package main;

import data.FileDataModel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.UserInterface;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws Exception {
    UserInterface ui = new UserInterface(stage);
    ui.start();
  }

  @Override
  public void stop() throws Exception {
    super.stop();
    FileDataModel.getInstance().saveAll();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

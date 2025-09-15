package controller;

import java.io.IOException;
import java.time.Year;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Book;
import model.Category;
import model.Library;
import view.UserInterface;

public class AddBookController implements Controller {
  private UserInterface userInterface;
  private Library library;

  @FXML
  private TextField titleField;
  @FXML
  private TextField authorField;
  @FXML
  private TextField isbnField;

  @FXML
  private ComboBox<Integer> yearComboBox;
  @FXML
  private ComboBox<Category> categoryComboBox;

  @FXML
  private Label errorLabel;

  @FXML
  private Button addButton;

  @FXML
  public void initialize() {
    int currentYear = Year.now().getValue();
    for (int y = currentYear; y >= currentYear - 300; y--) {
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
  private void handleAddBookClick() throws IOException {
    String title = titleField.getText().trim();
    String author = authorField.getText().trim();
    String isbn = isbnField.getText().trim();

    Integer publicationYear = yearComboBox.getValue();
    Category category = categoryComboBox.getValue();

    boolean fieldsEmpty = title.isEmpty()
      || author.isEmpty()
      || isbn.isEmpty()
      || publicationYear == null
      || category == null;

    if (fieldsEmpty) {
      errorLabel.setText("Cannot proceed — one or more fields are empty.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    if (this.library.searchBookByISBN(isbn) != null) {
      errorLabel.setText("A book with this ISBN already exists.");
      errorLabel.setVisible(true);
      errorLabel.setManaged(true);
      return;
    }

    errorLabel.setVisible(false);
    errorLabel.setManaged(false);

    Book book = new Book(title, author, isbn, category, publicationYear, false);
    this.library.addBook(book);

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Success");
    alert.setHeaderText(null);
    alert.setContentText("✅ Book added successfully.");
    alert.showAndWait();

    userInterface.loadPage("/manage_books.fxml");
  }


  public void postInit() {
    List<Category> categories = this.library.getCategories();
    if (categories.isEmpty()) {
      categories.add(new Category("Fiction", "Books that contain stories created from the imagination."));
      categories.add(new Category("Literary Fiction", "Books that focus on the quality of writing and character development."));
      categories.add(new Category("Historical Fiction", "Books that are set in a specific historical period."));
      categories.add(new Category("Science Fiction", "Books that explore futuristic concepts, technology, and alien worlds."));
      categories.add(new Category("Fantasy", "Books set in magical worlds with supernatural events or characters."));
      categories.add(new Category("Mystery", "Books that involve solving a crime or uncovering secrets."));
      categories.add(new Category("Thriller", "Books that are designed to keep readers on the edge of their seat with suspenseful plots."));
      categories.add(new Category("Romance", "Books that focus on love stories and romantic relationships."));
      categories.add(new Category("Horror", "Books that are designed to evoke fear or dread in the reader."));
      categories.add(new Category("Adventure", "Books that focus on exciting and often dangerous quests or journeys."));

      categories.add(new Category("Non-Fiction", "Books that are based on factual information or real events."));
      categories.add(new Category("Biography", "Books that provide a detailed account of someone's life."));
      categories.add(new Category("Autobiography", "Books where the author tells the story of their own life."));
      categories.add(new Category("Self-help", "Books aimed at helping the reader improve their life or personal situation."));
      categories.add(new Category("Philosophy", "Books that explore the nature of existence, knowledge, and ethics."));
      categories.add(new Category("Psychology", "Books that examine the human mind and behavior."));
      categories.add(new Category("Health & Wellness", "Books about physical and mental health, wellness, and self-care."));
      categories.add(new Category("Business & Economics", "Books about business practices, financial markets, and economic theories."));
      categories.add(new Category("Politics", "Books about governance, political systems, and public policies."));
      categories.add(new Category("History", "Books that explore past events and their impact on the present."));
      categories.add(new Category("Travel", "Books that describe travels, cultures, and countries around the world."));
      categories.add(new Category("Art & Architecture", "Books that focus on visual art, artists, and architectural design."));
      categories.add(new Category("Cooking", "Books that provide recipes, cooking techniques, and culinary knowledge."));
      categories.add(new Category("Science", "Books about scientific principles, discoveries, and theories."));
      categories.add(new Category("Education", "Books about teaching methods, learning theories, and educational systems."));

      categories.add(new Category("Children’s Books", "Books intended for children, usually with illustrations and simple themes."));
      categories.add(new Category("Picture Books", "Books with large pictures and minimal text for very young readers."));
      categories.add(new Category("Early Readers", "Books with simple text designed for children who are learning to read."));
      categories.add(new Category("Chapter Books", "Books aimed at young readers, typically divided into short chapters."));
      categories.add(new Category("Young Adult", "Books written for a teen audience, with relatable themes and characters."));

      categories.add(new Category("Poetry", "Books that consist of poems, focusing on language, emotion, and rhythm."));

      categories.add(new Category("Graphic Novels", "Books that combine illustrations and text to tell a story, often with comic book format."));
      categories.add(new Category("Comics", "Books or magazines containing illustrated stories, usually in a sequence of panels."));

      categories.add(new Category("Reference", "Books that provide factual information and are designed for quick lookup."));
      categories.add(new Category("Dictionaries", "Books that list words alphabetically and provide their meanings."));
      categories.add(new Category("Encyclopedias", "Books that provide comprehensive details on a wide range of subjects."));
      categories.add(new Category("Atlases", "Books containing maps or charts of geographical locations."));

      categories.add(new Category("Religious", "Books that explore faith, religion, and spiritual teachings."));
      categories.add(new Category("Christianity", "Books that explore Christian faith, theology, and history."));
      categories.add(new Category("Islam", "Books that explore Islamic teachings, beliefs, and history."));
      categories.add(new Category("Buddhism", "Books about the teachings, history, and practices of Buddhism."));
      categories.add(new Category("Hinduism", "Books exploring the philosophy, religion, and practices of Hinduism."));
      categories.add(new Category("Mythology", "Books about ancient myths, gods, and folklore from various cultures."));
    }
    categoryComboBox.getItems().addAll(this.library.getCategories());
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

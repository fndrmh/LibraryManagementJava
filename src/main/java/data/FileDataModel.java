package data;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import model.*;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONList;
import jsonlib.types.JSONDict;
import jsonlib.JSONSerializableFactory;
import jsonlib.JSONParser;
import jsonlib.JSONExpectFailedException;

public class FileDataModel {
  private static final String BOOKS_FILEPATH = "books.json";
  private static final String STUDENTS_FILEPATH = "students.json";
  private static final String CATEGORIES_FILEPATH = "categories.json";
  private static final String LOANS_FILEPATH = "loans.json";

  private List<Book> books;
  private List<Category> categories;
  private List<Student> students;
  private List<Loan> loans;

  private static FileDataModel instance;

  private FileDataModel() {
    this.loadAll();
  }

  public static FileDataModel getInstance() {
    if (instance == null)
      instance = new FileDataModel();

    return instance;
  }

  public List<Book> getBooks() {
    return this.books;
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public List<Loan> getLoans() {
    return this.loans;
  }

  public List<Category> getCategories() {
    return this.categories;
  }

  public void updateBooks(List<Book> books) {
    this.books = books;
  }

  public void updateCategories(List<Category> categories) {
    this.categories = categories;
  }

  public void updateStudents(List<Student> students) {
    this.students = students;
  }

  public void updateLoans(List<Loan> loans) {
    this.loans = loans;
  }

  private void loadAll() {
    this.books = loadFromFile(BOOKS_FILEPATH);
    this.students = loadFromFile(STUDENTS_FILEPATH);
    this.categories = loadFromFile(CATEGORIES_FILEPATH);
    this.loans = loadFromFile(LOANS_FILEPATH);
  }

  public void saveAll() {
    writeToFile(BOOKS_FILEPATH, JSONObject.fromList(this.books).toString());
    writeToFile(STUDENTS_FILEPATH, JSONObject.fromList(this.students).toString());
    writeToFile(CATEGORIES_FILEPATH, JSONObject.fromList(this.categories).toString());
    writeToFile(LOANS_FILEPATH, JSONObject.fromList(this.loans).toString());
  }

  public void writeToFile(String filePath, String data) {
    try (FileWriter writer = new FileWriter(filePath)) {
      writer.write(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String readFromFile(String filePath) {
    String content = new String();
    try {
      content = String.join("\n", Files.readAllLines(Paths.get(filePath)));
    } catch (IOException e) {
      return null;
    }

    return content;
  }

  public <T> List<T> loadFromFile(String filePath) {
    String content = readFromFile(filePath);
    if (content == null) {
      return new ArrayList<>();
    }

    JSONParser parser = new JSONParser(content);

    JSONObject jsonObj = null;

    try {
      jsonObj = parser.parse();
    } catch (JSONExpectFailedException e) {
      e.printStackTrace();
    }

    List<T> result = new ArrayList<>();
    JSONList listJSON = (JSONList) jsonObj;

    for (JSONObject itemJSON : listJSON) {
      T item = (T) JSONSerializableFactory.deserialize((JSONDict) itemJSON);
      result.add(item);
    }

    return result;
  }

}

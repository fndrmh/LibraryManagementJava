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

  public List<Book> loadBooks() {
    return loadFromFile(BOOKS_FILEPATH);
  }

  public List<Student> loadStudents() {
    return loadFromFile(STUDENTS_FILEPATH);
  }

  public List<Category> loadCategories() {
    return loadFromFile(CATEGORIES_FILEPATH);
  }

  public List<Loan> loadLoans() {
    return loadFromFile(LOANS_FILEPATH);
  }

  public void saveBooks(List<Book> books) {
    writeToFile(BOOKS_FILEPATH, JSONObject.fromList(books).toString());
  }

  public void saveStudents(List<Student> students) {
    writeToFile(STUDENTS_FILEPATH, JSONObject.fromList(students).toString());
  }

  public void saveCategories(List<Category> categories) {
    writeToFile(CATEGORIES_FILEPATH, JSONObject.fromList(categories).toString());
  }

  public void saveLoans(List<Loan> loans) {
    writeToFile(LOANS_FILEPATH, JSONObject.fromList(loans).toString());
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

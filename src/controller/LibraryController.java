package controller;

import data.FileDataModel;
import jsonlib.JSONSerializableFactory;

import java.util.List;

import model.*;

public class LibraryController {
  private Library library;
  private FileDataModel fileDataModel;

  public LibraryController() {
    library = new Library();
    fileDataModel = new FileDataModel();
    JSONSerializableFactory.registerType("UndergraduateStudent", UndergraduateStudent.class);
    JSONSerializableFactory.registerType("GraduateStudent", GraduateStudent.class);
    JSONSerializableFactory.registerType("Book", Book.class);
    JSONSerializableFactory.registerType("Category", Category.class);
    JSONSerializableFactory.registerType("Loan", Loan.class);

    loadData();
  }

  public void addUndergraduateStudent(String studentId, String firstName, String lastName, String major,
      int enrollmentYear) {
    Student student = new UndergraduateStudent(studentId, firstName, lastName, major, enrollmentYear);
    library.addStudent(student);
  }

  public void addGraduateStudent(String studentId, String firstName, String lastName, String major, String supervisor,
      String thesisTitle) {
    Student student = new GraduateStudent(studentId, firstName, lastName, major, supervisor, thesisTitle);
    library.addStudent(student);
  }

  public Student searchStudent(String studentId) {
    return library.searchStudentById(studentId);
  }

  public void removeStudent(String studentId) {
    library.removeStudent(studentId);
  }

  public List<Student> getAllStudents() {
    return library.getAllStudents();
  }

  public void addBook(String title, String author, String isbn, Category category, int publicationYear) {
    Book book = new Book(title, author, isbn, category, publicationYear, false);
    library.addBook(book);

  }

  public void removeBook(String isbn) {
    library.removeBook(isbn);
  }

  public Book searchBookByTitle(String title) {
    return library.searchBookByTitle(title);
  }

  public Book searchBookByISBN(String isbn) {
    return library.searchBookByISBN(isbn);
  }

  public List<Book> getAvailableBooks() {
    return library.getAvailableBooks();
  }

  public void borrowBook(Book book, Student student) {
    library.borrowBook(book, student);

  }

  public void returnBook(Book book) {
    library.returnBook(book);
  }

  public List<Book> getBorrowedBooksByStudent(String studentId) {
    return library.getBorrowedBooksByStudent(studentId);
  }

  public List<Book> getBooksByCategory(String categoryName) {
    return library.getBooksByCategory(categoryName);
  }

  public List<Student> getStudentsByMajor(String major) {
    return library.getStudentsByMajor(major);
  }

  public void saveData() {
    fileDataModel.saveBooks(library.getBooks());
    fileDataModel.saveCategories(library.getCategories());
    fileDataModel.saveLoans(library.getLoans());
    fileDataModel.saveStudents(library.getAllStudents());
  }

  public void loadData() {
    library.setBooks(fileDataModel.loadBooks());
    library.setCategories(fileDataModel.loadCategories());
    library.setLoans(fileDataModel.loadLoans());
    library.setStudents(fileDataModel.loadStudents());
  }

}

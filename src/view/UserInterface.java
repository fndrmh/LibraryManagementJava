package view;

import java.util.List;
import model.*;
import java.util.Scanner;
import controller.LibraryController;

public class UserInterface {
    private LibraryController libraryController;
    private Scanner scanner;

    public UserInterface() {
        libraryController = new LibraryController();
        scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println(
                       "                      ██╗   ██╗ ██████╗██████╗   ██╗     ██╗██████╗                       \n"+
                       "██████╗██████╗██████╗ ██║   ██║██╔════╝██╔══██╗  ██║     ██║██╔══██╗ ██████╗██████╗██████╗\n"+
                       "╚═════╝╚═════╝╚═════╝ ██║   ██║╚█████╗ ██████╦╝  ██║     ██║██████╦╝ ╚═════╝╚═════╝╚═════╝\n"+
                       "██████╗██████╗██████╗ ██║   ██║ ╚═══██╗██╔══██╗  ██║     ██║██╔══██╗ ██████╗██████╗██████╗\n"+
                       "╚═════╝╚═════╝╚═════╝ ║██████╔╝██████╔╝██████╦╝  ███████╗██║██████╦╝ ╚═════╝╚═════╝╚═════╝\n"+
                       "                      ╚══════╝╚══════╝ ╚═════╝   ╚══════╝╚═╝╚═════╝                       \n"+
                       "███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗  ██╗████████╗\n"+
                       "████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗ ██║╚══██╔══╝\n"+
                       "██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗  ██╔████╔██║█████╗  ██╔██╗██║   ██║   \n"+
                       "██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚████║   ██║   \n"+
                       "██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚███║   ██║   \n"+
                       "╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚══╝   ╚═╝   \n"+
                       "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Manage Users░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Manage Books░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➌)══> Loans       ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➍)══> Reports     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Exit        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    public void printManageUsersMenu(){
        System.out.println(
                "                      ███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗                      \n"+
                "██████╗██████╗██████╗ ████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝ ██████╗██████╗██████╗\n"+
                "╚═════╝╚═════╝╚═════╝ ██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗   ╚═════╝╚═════╝╚═════╝\n"+
                "██████╗██████╗██████╗ ██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝   ██████╗██████╗██████╗\n"+
                "╚═════╝╚═════╝╚═════╝ ██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗ ╚═════╝╚═════╝╚═════╝\n"+
                "                      ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                      \n"+
                "                            ██╗   ██╗ ██████╗███████╗██████╗  ██████╗                            \n"+
                "██████╗██████╗██████╗██████╗██║   ██║██╔════╝██╔════╝██╔══██╗██╔════╝██████╗██████╗██████╗██████╗\n"+
                "╚═════╝╚═════╝╚═════╝╚═════╝██║   ██║╚█████╗ █████╗  ██████╔╝╚█████╗ ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                "██████╗██████╗██████╗██████╗██║   ██║ ╚═══██╗██╔══╝  ██╔══██╗ ╚═══██╗██████╗██████╗██████╗██████╗\n"+
                "╚═════╝╚═════╝╚═════╝╚═════╝╚██████╔╝██████╔╝███████╗██║  ██║██████╔╝╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                "                             ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝                             \n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Add Undergraduate Student░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Add Graduate Student     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➌)══> Search Student by ID     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➍)══> Remove Student by ID     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➎)══> List All Students        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Main Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    public void printManageBooksMenu() {
        System.out.println(
                        "                      ███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗                      \n"+
                        "██████╗██████╗██████╗ ████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝ ██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝ ██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗   ╚═════╝╚═════╝╚═════╝\n"+
                        "██████╗██████╗██████╗ ██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝   ██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝ ██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗ ╚═════╝╚═════╝╚═════╝\n"+
                        "                      ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                      \n"+
                        "                            ██████╗  █████╗  █████╗ ██╗  ██╗ ██████╗                             \n"+
                        "██████╗██████╗██████╗██████╗██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝██╔════╝ ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝██████╦╝██║  ██║██║  ██║█████═╝ ╚█████╗  ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "██████╗██████╗██████╗██████╗██╔══██╗██║  ██║██║  ██║██╔═██╗  ╚═══██╗ ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝██████╦╝╚█████╔╝╚█████╔╝██║ ╚██╗██████╔╝ ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "                            ╚═════╝  ╚════╝  ╚════╝ ╚═╝  ╚═╝╚═════╝                              \n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Add Book                 ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Remove Book by ISBN      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➌)══> Search Book              ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➍)══> List All Available Books ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Main Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }

    public void printSearchBookMenu(){
        System.out.println(
                        "                         ██████╗███████╗ █████╗ ██████╗  █████╗ ██╗  ██╗                         \n"+
                        "██████╗██████╗██████╗   ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔══██╗██║  ██║    ██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝   ╚█████╗ █████╗  ███████║██████╔╝██║  ╚═╝███████║    ╚═════╝╚═════╝╚═════╝\n"+
                        "██████╗██████╗██████╗    ╚═══██╗██╔══╝  ██╔══██║██╔══██╗██║  ██╗██╔══██║    ██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝   ██████╔╝███████╗██║  ██║██║  ██║╚█████╔╝██║  ██║    ╚═════╝╚═════╝╚═════╝\n"+
                        "                        ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚════╝ ╚═╝  ╚═╝                         \n"+
                        "                                ██████╗  █████╗  █████╗ ██╗  ██╗                                 \n"+
                        "██████╗██████╗██████╗██████╗    ██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝     ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝    ██████╦╝██║  ██║██║  ██║█████═╝      ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "██████╗██████╗██████╗██████╗    ██╔══██╗██║  ██║██║  ██║██╔═██╗      ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝    ██████╦╝╚█████╔╝╚█████╔╝██║ ╚██╗     ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "                                ╚═════╝  ╚════╝  ╚════╝ ╚═╝  ╚═╝                                 \n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Search by Title          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Search by ISBN           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Book Management  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" );
    }

    public void printLoanMenu(){
        System.out.println(
                        "██████╗██████╗██████╗██████╗    ██║     ██╗  ██╗██╗  ██╗████╗ ██╗    ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝    ██║     ██║  ██║███████║██╔██╗██║    ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "                                ██║     ██║  ██║██╔══██║██║╚████║                                \n"+
                        "██████╗██████╗██████╗██████╗    ███████╗╚█████╔╝██║  ██║██║ ╚███║    ██████╗██████╗██████╗██████╗\n"+
                        "╚═════╝╚═════╝╚═════╝╚═════╝    ╚══════╝ ╚════╝ ╚═╝  ╚═╝╚═╝  ╚══╝    ╚═════╝╚═════╝╚═════╝╚═════╝\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Check Out Books          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Return Books             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Loan Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }

    public void printReportsMenu(){
        System.out.println(
                        "                    ██████╗ ███████╗██████╗  █████╗ ██████╗ ████████╗ ██████╗                    \n"+
                        "██████╗██████╗      ██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██╔════╝      ██████╗██████╗\n"+
                        "╚═════╝╚═════╝      ██████╔╝█████╗  ██████╔╝██║  ██║██████╔╝   ██║   ╚█████╗       ╚═════╝╚═════╝\n"+
                        "                    ██╔══██╗██╔══╝  ██╔═══╝ ██║  ██║██╔══██╗   ██║    ╚═══██╗                    \n"+
                        "██████╗██████╗      ██║  ██║███████╗██║     ╚█████╔╝██║  ██║   ██║   ██████╔╝      ██████╗██████╗\n"+
                        "╚═════╝╚═════╝      ╚═╝  ╚═╝╚══════╝╚═╝      ╚════╝ ╚═╝  ╚═╝   ╚═╝   ╚═════╝       ╚═════╝╚═════╝\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> List Books by Category           ░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> List Books Borrowed by a Student ░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> List Students by Major           ░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Main Menu                ░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
    }

    public void displayMainMenu() {
        while (true) {
            printMainMenu();
            int choice = readIntInRange("Enter a number", 0, 4);
            switch (choice) {
                case 1:
                    displayMemberMenu();
                    break;
                case 2:
                    displayBookMenu();
                    break;
                case 3:
                    displayLoanMenu();
                    break;
                case 4:
                    displayReportMenu();
                    break;
                case 0:
                    libraryController.saveData();
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public void displayMemberMenu() {
        while (true) {
            printManageUsersMenu();
            int choice = readIntInRange("Enter a number", 0, 5);
            switch (choice) {
                case 1: {
                    String studentID = readString("Enter the Student ID");
                    String firstName = readString("Enter the Student First Name");
                    String lastName = readString("Enter the Student Last Name");
                    String major = readString("Enter the Student Major");
                    int enrollmentYear = readIntInRange("Enter the Student Enrollment Year", 1000, 3000);
                    libraryController.addUndergraduateStudent(studentID, firstName, lastName, major, enrollmentYear);
                    break;
                }
                case 2: {
                    String studentID = readString("Enter the Student ID");
                    String firstName = readString("Enter the Student First Name");
                    String lastName = readString("Enter the Student Last Name");
                    String major = readString("Enter the Student Major");
                    String supervisor = readString("Enter the Student Supervisor");
                    String thesisTitle = readString("Enter the Student Thesis Title");
                    libraryController.addGraduateStudent(studentID, firstName, lastName, major, supervisor, thesisTitle);
                    break;
                }
                case 3: {
                    Student student = libraryController.searchStudent(readString("Enter Student ID"));
                    if (student == null)
                      System.out.println("Student not found!");
                    else
                      System.out.println(student);
                    break;
                }
                case 4: {
                    String studentID = readString("Enter the Student ID");
                    libraryController.removeStudent(studentID);
                    break;
                }
                case 5:
                    displayAllStudents(libraryController.getAllStudents());
                    break;
                case 0:
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public void displayBookMenu() {
        while (true) {
            printManageBooksMenu();
            int choice = readIntInRange("Enter a number", 0, 4);
            switch (choice) {
                case 1: {
                    String title = readString("Enter the title");
                    String author = readString("Enter the author");
                    String isbn = readString("Enter the ISBN");
                    int publicationYear = readIntInRange("Enter the publication year", 1000, 3000);
                    Category category = readSelection("Select a category", libraryController.getCategories());
                    libraryController.addBook(title, author, isbn, category, publicationYear);
                    break;
                }
                case 2: {
                    String isbn = readString("Enter the ISBN");
                    libraryController.removeBook(isbn);
                    break;
                }
                case 3: 
                    displaySearchBookMenu();
                    break;
                case 4:
                    displayAllBooks(libraryController.getAvailableBooks());
                    break;
                case 0:
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public void displaySearchBookMenu() {
      printSearchBookMenu();
      int choice = readIntInRange("Enter a number", 0, 2);
      switch (choice){
        case 1: {
          Book book = libraryController.searchBookByTitle(readString("Enter Book Title"));
          if (book == null)
            System.out.println("Book not found!");
          else
            System.out.println(book);
          break;
        }
        case 2: {
          String isbn = readString("Enter the book ISBN");
          Book book = libraryController.searchBookByISBN(isbn);
          if (book == null)
            System.out.println("Book not found!");
          else
            System.out.println(book);
          break;
        }
        case 0:
          return;
      }

    }

    public void displayLoanMenu() {
        while (true) {
            printLoanMenu();
            int choice = readIntInRange("Enter a number", 0, 2);
            switch (choice) {
                case 1: {
                    String studentID = readString("Enter you Student ID");
                    Student student = libraryController.searchStudent(studentID);
                    if (student == null) {
                      System.out.println("Student not found!");
                      continue;
                    }
                    List<Book> availableBooks = libraryController.getAvailableBooks();
                    if (availableBooks == null || availableBooks.size() == 0) {
                      System.out.println("No books available right now!");
                      continue;
                    }

                    Book selectedBook = readSelection("Which book do you want to borrow?", availableBooks);
                    libraryController.borrowBook(selectedBook, student);
                    break;
                }
                case 2: {
                    String studentID = readString("Enter your Student ID");
                    if (libraryController.searchStudent(studentID) == null) {
                      System.out.println("Student not found!");
                      continue;
                    }
                    List<Book> books = libraryController.getBorrowedBooksByStudent(studentID);
                    if (books == null || books.size() == 0) {
                      System.out.println("You haven't borrowed any book!");
                      continue;
                    }
                    Book selectedBook = readSelection("Which book do you want to return?", books);
                    libraryController.returnBook(selectedBook);
                    break;
                }
                case 0:
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public void displayReportMenu() {
        while (true) {
            printReportsMenu();
            int choice = readIntInRange("Enter a number", 0, 3);
            switch (choice) {
                case 1: {
                    List<Category> categories = libraryController.getCategories();
                    if (categories == null || categories.size() == 0) {
                      System.out.println("No categories available rightt now!");
                      continue;
                    }
                    Category category = readSelection("Choose a category", categories);
                    List<Book> books = libraryController.getBooksByCategory(category);
                    if (books == null || books.size() == 0) {
                      System.out.println("No books available in this category");
                      continue;
                    }
                    displayReport(books);
                    break;
                }
                case 2: {
                    String studentID = readString("Enter your Student ID");
                    if (libraryController.searchStudent(studentID) == null) {
                      System.out.println("Student not found!");
                      continue;
                    }
                    List<Book> books = libraryController.getBorrowedBooksByStudent(studentID);
                    if (books == null || books.size() == 0) {
                      System.out.println("You haven't borrowed any book!");
                      continue;
                    }
                    displayReport(books);
                    break;
                }
                case 3: {
                    String major = readString("Enter a major");
                    List<Student> students = libraryController.getStudentsByMajor(major);
                    if (students == null || students.size() == 0) {
                      System.out.println("No students found in this major");
                      continue;
                    }

                    displayReport(students);
                    break;
                }
                case 0:
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public void displayAllStudents(List<Student> students) {
      for (Student student : students) {
        System.out.println(student);
      }
    }

    public void displayAllBooks(List<Book> books) {
      for (Book book : books) {
        System.out.println(book);
      }
    }

    public <T extends BaseModel> void displayReport(List<T> results) {
      for (int i = 0; i < results.size(); i++)
        System.out.printf("%d. %s\n", i, results.get(i).getDisplayName());
    }

    private void printPrompt(String prompt) {
        System.out.print(String.format("░░░░░░░░░░░░░░░░░░░░░░░░░░║%s║══> ", prompt));
        System.out.flush();
    }

    private void printInvalidInput() {
      System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
      System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid characters⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
      System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    private void clearScannerBuffer() {
      if (scanner.hasNextLine())
        scanner.nextLine();
    }

    private int readIntInRange(String prompt, int min, int max) {
      while (true) {
        printPrompt(prompt);
        try {
          int input = scanner.nextInt();
          clearScannerBuffer();
          if (input >= min && input <= max)
            return input;
          else {
            printInvalidInput();
            continue;
          }
        } catch (Exception e) {
          printInvalidInput();
          clearScannerBuffer();
          continue;
        }
      }
    }

    private String readString(String prompt) {
      printPrompt(prompt);
      // TODO: validiate input
      return scanner.nextLine();
    }  

    private <T extends BaseModel> T readSelection(String prompt, List<T> options) {
      if (options == null || options.size() == 0)
        return null;

      for (int i = 0; i < options.size(); i++) { 
        System.out.println(String.format("%d. %s", i, options.get(i).getDisplayName()));
      }

      return options.get(readIntInRange(prompt, 0, options.size()-1));
    }
}

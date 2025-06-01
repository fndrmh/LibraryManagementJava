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
            "                      ██╗   ██╗ ██████╗██████╗   ██╗     ██╗██████╗                       \n" +
            "██████╗██████╗██████╗ ██║   ██║██╔════╝██╔══██╗  ██║     ██║██╔══██╗ ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ██║   ██║╚█████╗ ██████╦╝  ██║     ██║██████╦╝ ╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗ ██║   ██║ ╚═══██╗██╔══██╗  ██║     ██║██╔══██╗ ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ║██████╔╝██████╔╝██████╦╝  ███████╗██║██████╦╝ ╚═════╝╚═════╝╚═════╝\n" +
            "                      ╚══════╝╚══════╝ ╚═════╝   ╚══════╝╚═╝╚═════╝                       \n" +
            "███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗███╗   ███╗███████╗███╗  ██╗████████╗\n" +
            "████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝████╗ ████║██╔════╝████╗ ██║╚══██╔══╝\n" +
            "██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗  ██╔████╔██║█████╗  ██╔██╗██║   ██║   \n" +
            "██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝  ██║╚██╔╝██║██╔══╝  ██║╚████║   ██║   \n" +
            "██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗██║ ╚═╝ ██║███████╗██║ ╚███║   ██║   \n" +
            "╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝     ╚═╝╚══════╝╚═╝  ╚══╝   ╚═╝   \n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> Manage Users░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> Manage Books░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(3)══> Loans       ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(4)══> Reports     ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Exit        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void printManageUsersMenu() {
    System.out.println(
            "                      ███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗                      \n" +
            "██████╗██████╗██████╗ ████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝ ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗   ╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗ ██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝   ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗ ╚═════╝╚═════╝╚═════╝\n" +
            "                      ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                      \n" +
            "                            ██╗   ██╗ ██████╗███████╗██████╗  ██████╗                            \n" +
            "██████╗██████╗██████╗██████╗██║   ██║██╔════╝██╔════╝██╔══██╗██╔════╝██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝██║   ██║╚█████╗ █████╗  ██████╔╝╚█████╗ ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗██████╗██║   ██║ ╚═══██╗██╔══╝  ██╔══██╗ ╚═══██╗██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝╚██████╔╝██████╔╝███████╗██║  ██║██████╔╝╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "                             ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝                             \n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> Add Undergraduate Student ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> Add Graduate Student      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(3)══> Search Student by ID      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(4)══> Remove Student by ID      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(5)══> List All Students         ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Back to Main Menu         ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void printManageBooksMenu() {
    System.out.println(
            "                      ███╗   ███╗ █████╗ ███╗  ██╗ █████╗  ██████╗ ███████╗                      \n" +
            "██████╗██████╗██████╗ ████╗ ████║██╔══██╗████╗ ██║██╔══██╗██╔════╝ ██╔════╝ ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ██╔████╔██║███████║██╔██╗██║███████║██║  ██╗ █████╗   ╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗ ██║╚██╔╝██║██╔══██║██║╚████║██╔══██║██║  ╚██╗██╔══╝   ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝ ██║ ╚═╝ ██║██║  ██║██║ ╚███║██║  ██║╚██████╔╝███████╗ ╚═════╝╚═════╝╚═════╝\n" +
            "                      ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝                      \n" +
            "                            ██████╗  █████╗  █████╗ ██╗  ██╗ ██████╗                             \n" +
            "██████╗██████╗██████╗██████╗██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝██╔════╝ ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝██████╦╝██║  ██║██║  ██║█████═╝ ╚█████╗  ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗██████╗██╔══██╗██║  ██║██║  ██║██╔═██╗  ╚═══██╗ ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝██████╦╝╚█████╔╝╚█████╔╝██║ ╚██╗██████╔╝ ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "                            ╚═════╝  ╚════╝  ╚════╝ ╚═╝  ╚═╝╚═════╝                              \n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> Add Book                 ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> Remove Book by ISBN      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(3)══> Search Book              ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(4)══> List All Available Books ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Back to Main Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void printSearchBookMenu() {
    System.out.println(
            "                         ██████╗███████╗ █████╗ ██████╗  █████╗ ██╗  ██╗                         \n" +
            "██████╗██████╗██████╗   ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔══██╗██║  ██║    ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝   ╚█████╗ █████╗  ███████║██████╔╝██║  ╚═╝███████║    ╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗    ╚═══██╗██╔══╝  ██╔══██║██╔══██╗██║  ██╗██╔══██║    ██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝   ██████╔╝███████╗██║  ██║██║  ██║╚█████╔╝██║  ██║    ╚═════╝╚═════╝╚═════╝\n" +
            "                        ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚════╝ ╚═╝  ╚═╝                         \n" +
            "                                ██████╗  █████╗  █████╗ ██╗  ██╗                                 \n" +
            "██████╗██████╗██████╗██████╗    ██╔══██╗██╔══██╗██╔══██╗██║ ██╔╝     ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝    ██████╦╝██║  ██║██║  ██║█████═╝      ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗██████╗    ██╔══██╗██║  ██║██║  ██║██╔═██╗      ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝    ██████╦╝╚█████╔╝╚█████╔╝██║ ╚██╗     ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "                                ╚═════╝  ╚════╝  ╚════╝ ╚═╝  ╚═╝                                 \n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> Search by Title          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> Search by ISBN           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Back to Book Management  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void printLoanMenu() {
    System.out.println(
            "                                ██╗      █████╗  █████╗ ███╗  ██╗                                \n" +
            "██████╗██████╗██████╗██████╗    ██║     ██╗  ██╗██╗  ██╗████╗ ██╗    ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝    ██║     ██║  ██║███████║██╔██╗██║    ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "██████╗██████╗██████╗██████╗    ██║     ██║  ██║██╔══██║██║╚████║    ██████╗██████╗██████╗██████╗\n" +
            "╚═════╝╚═════╝╚═════╝╚═════╝    ███████╗╚█████╔╝██║  ██║██║ ╚███║    ╚═════╝╚═════╝╚═════╝╚═════╝\n" +
            "                                ╚══════╝ ╚════╝ ╚═╝  ╚═╝╚═╝  ╚══╝                                \n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> Check Out Books          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> Return Books             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Back to Loan Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void printReportsMenu() {
    System.out.println(
            "                    ██████╗ ███████╗██████╗  █████╗ ██████╗ ████████╗ ██████╗                    \n" +
            "██████╗██████╗      ██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝██╔════╝      ██████╗██████╗\n" +
            "╚═════╝╚═════╝      ██████╔╝█████╗  ██████╔╝██║  ██║██████╔╝   ██║   ╚█████╗       ╚═════╝╚═════╝\n" +
            "                    ██╔══██╗██╔══╝  ██╔═══╝ ██║  ██║██╔══██╗   ██║    ╚═══██╗                    \n" +
            "██████╗██████╗      ██║  ██║███████╗██║     ╚█████╔╝██║  ██║   ██║   ██████╔╝      ██████╗██████╗\n" +
            "╚═════╝╚═════╝      ╚═╝  ╚═╝╚══════╝╚═╝      ╚════╝ ╚═╝  ╚═╝   ╚═╝   ╚═════╝       ╚═════╝╚═════╝\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(1)══> List Books by Category           ░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(2)══> List Books Borrowed by a Student ░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(3)══> List Students by Major           ░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(0)══> Back to Main Menu                ░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
  }

  public void displayMainMenu() {
    while (true) {
      clearScreen();
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
          assert false : "UNREACHABLE";
      }
    }
  }

  public void displayMemberMenu() {
    while (true) {
      clearScreen();
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
          printSuccess("New student added successfully!");
          pause();
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
          printSuccess("New student added successfully!");
          pause();
          break;
        }
        case 3: {
          Student student = libraryController.searchStudent(readString("Enter Student ID"));
          if (student == null)
            printError("Student not found!");
          else
            System.out.println(student);
          pause();
          break;
        }
        case 4: {
          String studentID = readString("Enter the Student ID");
          libraryController.removeStudent(studentID);
          break;
        }
        case 5:
          displayAllStudents(libraryController.getAllStudents());
          pause();
          break;
        case 0:
          return;
        default:
          assert false : "UNREACHABLE";
      }
    }
  }

  public void displayBookMenu() {
    while (true) {
      clearScreen();
      printManageBooksMenu();
      int choice = readIntInRange("Enter a number", 0, 4);
      switch (choice) {
        case 1: {
          String title = readString("Enter the title");
          String author = readString("Enter the author");
          String isbn = readString("Enter the ISBN");
          int publicationYear = readIntInRange("Enter the publication year", 1000, 3000);
          List<Category> categories = libraryController.getCategories();
          Category category = readCategorySelection(categories);
          libraryController.addBook(title, author, isbn, category, publicationYear);
          printSuccess("New book added successfully!");
          pause();
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
          pause();
          break;
        case 0:
          return;
        default:
          assert false : "UNREACHABLE";
      }
    }
  }

  public void displaySearchBookMenu() {
    clearScreen();
    printSearchBookMenu();
    int choice = readIntInRange("Enter a number", 0, 2);
    switch (choice) {
      case 1: {
        Book book = libraryController.searchBookByTitle(readString("Enter Book Title"));
        if (book == null)
          printError("Book not found!");
        else
          System.out.println(book);
        pause();
        break;
      }
      case 2: {
        String isbn = readString("Enter the book ISBN");
        Book book = libraryController.searchBookByISBN(isbn);
        if (book == null)
          printError("Book not found!");
        else
          System.out.println(book);
        pause();
        break;
      }
      case 0:
        return;
    }

  }

  public void displayLoanMenu() {
    while (true) {
      clearScreen();
      printLoanMenu();
      int choice = readIntInRange("Enter a number", 0, 2);
      switch (choice) {
        case 1: {
          String studentID = readString("Enter you Student ID");
          Student student = libraryController.searchStudent(studentID);
          if (student == null) {
            printError("Student not found!");
            pause();
            continue;
          }
          List<Book> availableBooks = libraryController.getAvailableBooks();
          if (availableBooks == null || availableBooks.size() == 0) {
            printError("No books available right now!");
            pause();
            continue;
          }

          Book selectedBook = readSelection("Which book do you want to borrow?", availableBooks);
          libraryController.borrowBook(selectedBook, student);
          printSuccess("The book has been borrowed successfully!");
          pause();
          break;
        }
        case 2: {
          String studentID = readString("Enter your Student ID");
          if (libraryController.searchStudent(studentID) == null) {
            printError("Student not found!");
            pause();
            continue;
          }
          List<Book> books = libraryController.getBorrowedBooksByStudent(studentID);
          if (books == null || books.size() == 0) {
            printError("You haven't borrowed any book!");
            pause();
            continue;
          }
          Book selectedBook = readSelection("Which book do you want to return?", books);
          libraryController.returnBook(selectedBook);
          printSuccess("The book has been returned successfully!");
          pause();
          break;
        }
        case 0:
          return;
        default:
          assert false : "UNREACHABLE";
      }
    }
  }

  public void displayReportMenu() {
    while (true) {
      clearScreen();
      printReportsMenu();
      int choice = readIntInRange("Enter a number", 0, 3);
      switch (choice) {
        case 1: {
          List<Category> categories = libraryController.getCategories();
          if (categories == null || categories.size() == 0) {
            printError("No categories available right now!");
            pause();
            continue;
          }
          Category category = readSelection("Choose a category", categories);
          List<Book> books = libraryController.getBooksByCategory(category);
          if (books == null || books.size() == 0) {
            printError("No books available in this category!");
            pause();
            continue;
          }
          displayReport(books);
          pause();
          break;
        }
        case 2: {
          String studentID = readString("Enter your Student ID");
          if (libraryController.searchStudent(studentID) == null) {
            printError("Student not found!");
            pause();
            continue;
          }
          List<Book> books = libraryController.getBorrowedBooksByStudent(studentID);
          if (books == null || books.size() == 0) {
            printError("You haven't borrowed any book!");
            pause();
            continue;
          }
          displayReport(books);
          pause();
          break;
        }
        case 3: {
          String major = readString("Enter a major");
          List<Student> students = libraryController.getStudentsByMajor(major);
          if (students == null || students.size() == 0) {
            printError("No students found in this major!");
            pause();
            continue;
          }
          displayReport(students);
          pause();
          break;
        }
        case 0:
          return;
        default:
          assert false : "UNREACHABLE";
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
    printError("Please enter valid characters!");
  }

  public void printMessage(String msg, String emoji) {
    String border = "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░";
    String formattedMsg = String.format("░░░<<<%s %s %s>>>░░░", emoji, msg, emoji);

    int totalPadding = border.length() - formattedMsg.length();
    int leftPadding = totalPadding / 2;
    int rightPadding = totalPadding - leftPadding;
    String paddedMsg = "░".repeat(leftPadding) + formattedMsg + "░".repeat(rightPadding);

    System.out.println(border);
    System.out.println(paddedMsg);
    System.out.println(border);
  }
  
  public void printError(String msg) {
    printMessage(msg, "⚠ ");
  }

  public void printSuccess(String msg) {
    printMessage(msg, "✔ ");
  }

  public void printInfo(String msg) {
    printMessage(msg, "ⓘ");
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

  private Category createNewCategory() {
    String name = readString("Enter Category Name");
    String description = readString("Enter Category Description");
    libraryController.addCategory(name, description);
    printSuccess("New category created successfully!");
    return readCategorySelection(libraryController.getCategories());

  }

  private Category readCategorySelection(List<Category> categories) {
    if (categories == null || categories.size() == 0) {
      printError("No categories available!");
      printInfo("Creating a new category...");
      return createNewCategory();
    }

    for (int i = 0; i < categories.size(); i++)
      System.out.println(String.format("%d. %s", i, categories.get(i).getDisplayName()));

    System.out.println(String.format("%d. %s", categories.size(), "Add new category"));

    int choice = readIntInRange("Choose an option", 0, categories.size());
    if (choice == categories.size())
      return createNewCategory();
    else
      return categories.get(choice);
  }

  private <T extends BaseModel> T readSelection(String prompt, List<T> options) {
    if (options == null || options.size() == 0)
      return null;

    for (int i = 0; i < options.size(); i++) {
      System.out.println(String.format("%d. %s", i, options.get(i).getDisplayName()));
    }

    return options.get(readIntInRange(prompt, 0, options.size() - 1));
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();
  }

  public static void pause() {
    System.out.print("Press Enter to continue...");
    System.out.flush();
    try {
      System.in.read();
      // Clear the input buffer
      while (System.in.available() > 0) {
        System.in.read();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

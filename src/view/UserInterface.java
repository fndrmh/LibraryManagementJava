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
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Check Out Books          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Return Books             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n"+
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Loan Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
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
                    Student student = libraryController.searchStudent(getStudentIdForSearch());
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
                    // TODO: print list of available categories and let the user choose one or define one
                    libraryController.addBook(title, author, isbn, null, publicationYear);
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
        case 1:
          libraryController.searchBookByTitle(getBookTitleForSearch());
          break;
        case 2:
          String isbn = readString("Enter the book ISBN");
          libraryController.searchBookByISBN(isbn);
          break;
        case 0:
          return;
      }

    }

    public void displayLoanMenu() {
        while (true) {
            printLoanMenu();
            int choice = readIntInRange("Enter a number", 0, 2);
            switch (choice) {
                case 1:
                    // TODO: implement check out books
                    break;
                case 2:
                    // TODO: implement return books
                    break;
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
            int choice = readIntInRange("Enter a number", 0, 2);
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    return;
                default:
                    assert false: "UNREACHABLE";
            }
        }
    }

    public String getStudentIdForSearch() {
        return readString("Enter Student ID");
    }

    public void getBookISBNForOperation() {

    }

    public String getBookTitleForSearch() {
      return readString("Enter Book Title");
    }

    public void getStudentIdForLoan() {
    // TODO: Implement method 'getStudentIdForLoan'.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentIdForLoan'");
    }

    public void getBookISBNForLoan() {
    // TODO: Implement method 'getBookISBNForLoan'.
    throw new UnsupportedOperationException("Unimplemented method 'getBookISBNForLoan'");
    }

    public void displayStudentDetails(Student student) {
    // TODO: Implement method 'displayStudentDetails'.
    throw new UnsupportedOperationException("Unimplemented method 'displayStudentDetails'");
    }

    public void displayBookDetails(Book book) {

    }

    public void getBookDetailsForCreation() {
        // TODO: Implement method 'getBookDetailsForCreation'.
        throw new UnsupportedOperationException("Unimplemented method 'getBookDetailsForCreation'");
    }
    
    public void displayLoanDetails(Loan loan) {
        // TODO: Implement method 'displayLoanDetails'.
        throw new UnsupportedOperationException("Unimplemented method 'displayLoanDetails'");
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

    public void displayReport(List<?> results) {

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
}

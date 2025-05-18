package view;

import java.util.List;
import model.*;
import java.util.Scanner;

public class UserInterface {
    public void displayMainMenu() {
        while (true) {
            printMainMenu();
            Scanner inputin = new Scanner(System.in);
            int input = inputin.nextInt();
            switch (input) {
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
                    System.out.println("<<------------------------------------->>");
                    System.out.println("<<<<Please select the correct option!>>>>");
                    System.out.println("<<------------------------------------->>");
                    break;
            }
        }
    }

    public void printMainMenu() {
    System.out.println("░░░░░░░░░░░░ ██╗     ███╗   ███╗ ██████╗ ░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░ ██║     ████╗ ████║██╔════╝ ░░░░░░░░░░░░\n"+
                       "█████╗█████╗ ██║     ██╔████╔██║╚█████╗  █████╗█████╗\n"+
                       "╚════╝╚════╝ ██║     ██║╚██╔╝██║ ╚═══██╗ ╚════╝╚════╝\n"+
                       "░░░░░░░░░░░░ ███████╗██║ ╚═╝ ██║██████╔╝ ░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░ ╚══════╝╚═╝     ╚═╝╚═════╝  ░░░░░░░░░░░░\n"+
                       "░░░░░░░░░░░░ \uD83C\uDD3B\uD83C\uDD38\uD83C\uDD31\uD83C\uDD41\uD83C\uDD30\uD83C\uDD41\uD83C\uDD48 \uD83C\uDD3C\uD83C\uDD30\uD83C\uDD3D\uD83C\uDD30\uD83C\uDD36\uD83C\uDD34\uD83C\uDD3C\uD83C\uDD34\uD83C\uDD3D\uD83C\uDD43 \uD83C\uDD42\uD83C\uDD48\uD83C\uDD42\uD83C\uDD43\uD83C\uDD34\uD83C\uDD3C ░░░░░░░░░░░░░");
        System.out.println("(➊)==> Manage Users");
        System.out.println("(➋)==> Manage Books");
        System.out.println("(➌)==> Loans");
        System.out.println("(➍)==> Reports");
        System.out.println("(⓿)==> Exit");
    }

    public void displayMemberMenu() {
        // TODO: Implement method 'displayMemberMenu'.
        throw new UnsupportedOperationException("Unimplemented method 'displayMemberMenu'");
    }

    public void displayBookMenu() {
    // TODO: Implement method 'displayBookMenu'.
    throw new UnsupportedOperationException("Unimplemented method 'displayBookMenu'");
  }

  public void displayLoanMenu() {
    // TODO: Implement method 'displayLoanMenu'.
    throw new UnsupportedOperationException("Unimplemented method 'displayLoanMenu'");
  }

  public void displayReportMenu() {
    // TODO: Implement method 'displayReportMenu'.
    throw new UnsupportedOperationException("Unimplemented method 'displayReportMenu'");
  }

  public void getUndergraduateStudentDetails() {
    // TODO: Implement method 'getUndergraduateStudentDetails'.
    throw new UnsupportedOperationException("Unimplemented method 'getUndergraduateStudentDetails'");
  }

  public void getGraduateStudentDetails() {
    // TODO: Implement method 'getGraduateStudentDetails'.
    throw new UnsupportedOperationException("Unimplemented method 'getGraduateStudentDetails'");
  }

  public void getStudentIdForSearch() {
    // TODO: Implement method 'getStudentIdForSearch'.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentIdForSearch'");
  }

  public void getBookDetailsForCreation() {
    // TODO: Implement method 'getBookDetailsForCreation'.
    throw new UnsupportedOperationException("Unimplemented method 'getBookDetailsForCreation'");
  }

  public void getBookISBNForOperation() {
    // TODO: Implement method 'getBookISBNForOperation'.
    throw new UnsupportedOperationException("Unimplemented method 'getBookISBNForOperation'");
  }

  public void getBookTitleForSearch() {
    // TODO: Implement method 'getBookTitleForSearch'.
    throw new UnsupportedOperationException("Unimplemented method 'getBookTitleForSearch'");
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
    // TODO: Implement method 'displayBookDetails'.
    throw new UnsupportedOperationException("Unimplemented method 'displayBookDetails'");
  }

  public void displayAllStudents(List<Student> students) {
    // TODO: Implement method 'displayAllStudents'.
    throw new UnsupportedOperationException("Unimplemented method 'displayAllStudents'");
  }

  public void displayAllBooks(List<Book> books) {
    // TODO: Implement method 'displayAllBooks'.
    throw new UnsupportedOperationException("Unimplemented method 'displayAllBooks'");
  }

  public void displayLoanDetails(Loan loan) {
    // TODO: Implement method 'displayLoanDetails'.
    throw new UnsupportedOperationException("Unimplemented method 'displayLoanDetails'");
  }

  public void displayReport(List<?> results) {
    // TODO: Implement method 'displayReport'.
    throw new UnsupportedOperationException("Unimplemented method 'displayReport'");
  }
}

package view;

import java.util.List;
import model.*;
import java.util.Scanner;
import controller.LibraryController;

public class UserInterface {
    private LibraryController libraryController;

    public UserInterface() {
        libraryController = new LibraryController();
    }

    public void printMainMenu() {
        System.out.println("                      ██╗   ██╗ ██████╗██████╗   ██╗     ██╗██████╗                       \n"+
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
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➊)══> Add Book                 ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➋)══> Remove Book by ISBN      ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➌)══> Search Book              ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(➍)══> List All Available Books ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░(⓿)══> Back to Main Menu        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
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

    public void displayMainMenu() {
        while (true) {
            printMainMenu();//Menu print
            Scanner MainMenuInput = new Scanner(System.in);//Get input
            int mainmenuinput = 0;
            try {
                mainmenuinput = MainMenuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            }
            switch (mainmenuinput) {
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
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please select the correct option⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    break;
            }
        }
    }

    public void displayMemberMenu() {
        while (true) {
            printManageUsersMenu();
            Scanner MemberMenuInput = new Scanner(System.in);
            int membermenuinput = 0;
            try {
                membermenuinput = MemberMenuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            }
            switch (membermenuinput) {
                case 1:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
                    String ugstudentId = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student First Name║══> ");
                    String ugfirstName = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student LastName║══> ");
                    String uglastName = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Major║══> ");
                    String ugmajor = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Enrollment Year║══> ");
                    try{
                        int ugenrollmentYear = MemberMenuInput.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    }
                    libraryController.addUndergraduateStudent(ugstudentId, ugfirstName, uglastName, ugmajor, ugenrollmentYear);
                    break;
                case 2:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
                    String gstudentId = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student First Name║══> ");
                    String gfirstName = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student LastName║══> ");
                    String glastName = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Major║══> ");
                    String gmajor = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Supervisor║══> ");
                    String gsupervisor = MemberMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Thesis Title║══> ");
                    String gthesisTitle = MemberMenuInput.nextLine();
                    libraryController.addGraduateStudent(gstudentId, gfirstName, glastName, gmajor, gsupervisor, gthesisTitle);
                    break;
                case 3:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
                    String sstudentId = MemberMenuInput.nextLine();
                    LibraryController.searchStudent(sstudentId);
                    break;
                case 4:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
                    String rstudentId = MemberMenuInput.nextLine();
                    LibraryController.removeStudent(rstudentId);
                    break;
                case 5:
                    LibraryController.displayAllStudents();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please select the correct option⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    break;
            }
        }
    }

    public void displayBookMenu() {
        while (true) {
            printManageBooksMenu();
            Scanner BooksMenuInput = new Scanner(System.in);
            int booksmenuinput = 0;
            try {
                booksmenuinput = BooksMenuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            }
            switch (booksmenuinput) {
                case 1:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Title║══> ");
                    String title = BooksMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Author║══> ");
                    String author = BooksMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ISBN║══> ");
                    String isbn1 = BooksMenuInput.nextLine();
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student Publication Year║══> ");
                    int publicationYear = BooksMenuInput.nextInt();
                    libraryController.addBook(title, author, isbn1, publicationYear);
                    break;
                case 2:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ISBN║══> ");
                    String isbn2 = BooksMenuInput.nextLine();
                    libraryController.removeBook(isbn2);
                    break;
                case 3:
                    printSearchBookMenu();
                    int searchbookmenu = 0;
                    try {
                        searchbookmenu = BooksMenuInput.nextInt();
                    }
                    catch(Exception e) {
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    }
                    switch (searchbookmenu){
                        case 1:
                            String T;
                            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book Title║══> ");
                            T = BooksMenuInput.nextLine();
                            libraryController.searchBookByTitle(T);
                            break;
                        case 2:
                            String I;
                            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book ISBN║══> ");
                            I = BooksMenuInput.nextLine();
                            libraryController.searchBookByISBN(I);
                            break;
                        case 0:
                            return;
                    }
                    break;
                case 4:
                    libraryController.displayAvailableBooks();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please select the correct option⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░");
                    System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    break;
            }
        }
  }

  public void displayLoanMenu() {
      while (true) {
          printLoanMenu();
          Scanner loanMenuInput = new Scanner(System.in);
          int loanmenuinput = 0;
          try {
              loanmenuinput = loanMenuInput.nextInt();q
          }
          catch(Exception e) {
              System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
              System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
              System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
          }
          switch (loanmenuinput) {
              case 1:
                  ();
                  break;
              case 2:
                  ();
                  break;
              case 0:
                  return;
              default:
                  System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                  System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please select the correct option⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░");
                  System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                  break;
          }
      }
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

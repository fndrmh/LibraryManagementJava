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
                    int ugenrollmentyear = 0;
                    try{
                        ugenrollmentyear = MemberMenuInput.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                    }
                    libraryController.addUndergraduateStudent(ugstudentId, ugfirstName, uglastName, ugmajor, ugenrollmentyear);
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
                    libraryController.searchStudent(getStudentIdForSearch());
                    break;
                case 4:
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
                    String rstudentId = MemberMenuInput.nextLine();
                    libraryController.removeStudent(rstudentId);
                    break;
                case 5:
                    libraryController.getAllStudents();
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
                    // TODO: print list of available categories and let the user choose one or define one
                    libraryController.addBook(title, author, isbn1, null, publicationYear);
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
                            libraryController.searchBookByTitle(getBookTitleForSearch());
                            break;
                        case 2:
                            String isbn3;
                            System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book ISBN║══> ");
                            isbn3 = BooksMenuInput.nextLine();
                            libraryController.searchBookByISBN(isbn3);
                            break;
                        case 0:
                            return;
                    }
                    break;
                case 4:
                    libraryController.getAvailableBooks();
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
                loanmenuinput = loanMenuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            }
            switch (loanmenuinput) {
                case 1:
                    Book isbn4;
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book ISBN║══> ");
                    Student SID;
                    System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book Student ID║══> ");
                    //libraryController.borrowBook(isbn4, SID);
                    break;
                case 2:
                    Book isbn5;
                    //isbn5 = loanMenuInput.nextLine();
                    //libraryController.returnBook(isbn5);
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
        while (true) {
            printReportsMenu();
            Scanner reportsMenuInput = new Scanner(System.in);
            int reportsmenuinput = 0;
            try {
                reportsmenuinput = reportsMenuInput.nextInt();
            }
            catch(Exception e) {
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░<<<⚠⃨Please enter valid character⚠⃨>>>░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            }
            switch (reportsmenuinput) {
                case 1:
                    break;
                case 2:
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

    public String getStudentIdForSearch() {
        Scanner gSIFS = new Scanner(System.in);
        System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Student ID║══> ");
        String sstudentId = gSIFS.nextLine();
        return sstudentId;
    }

    public void getBookISBNForOperation() {

    }

    public String getBookTitleForSearch() {
        Scanner gBTFS = new Scanner(System.in);
        String T;
        System.out.print("░░░░░░░░░░░░░░░░░░░░░░░░░░║Enter The Book Title║══> ");
        T = gBTFS.nextLine();
        return T;
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
        System.out.println();
    }

    public void displayAllBooks(List<Book> books) {
    // TODO: Implement method 'displayAllBooks'.
    throw new UnsupportedOperationException("Unimplemented method 'displayAllBooks'");
    }

    public void displayReport(List<?> results) {

    }
}

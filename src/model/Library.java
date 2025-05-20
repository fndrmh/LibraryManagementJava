package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Library {
  private List<Book> books;
  private List<Student> students;
  private List<Category> categories;
  private List<Loan> loans;
//Constructor
  public Library(){
      books=new ArrayList<>();
      students=new ArrayList<>();
      categories=new ArrayList<>();
      loans=new ArrayList<>();
  }

  public void addBook(Book book) {
      books.add(book);
  }

  public void removeBook(String isbn) {
      for (Book book : books) {
            if(book.getIsbn().equals(isbn)){
                  books.remove(book);
            }
      }
  }

  public Book searchBookByTitle(String title) {
      for(Book book : books){
            if(book.getTitle().equals(title)){
                  return book;
            }
      }
      return null;
  }

  public Book searchBookByISBN(String isbn) {
            for(Book book : books){
            if(book.getTitle().equals(isbn)){
                  return book;
            }
      }
      return null;
  }

  public List<Book> getAvailableBooks() {
      List<Book> AvailableBooks=new ArrayList<>();
      for(Book book : books){
            if(!book.getIsBorrowed()){
                  AvailableBooks.add(book);
            }
      }
      return AvailableBooks;
  }

  public void addStudent(Student student) {
      students.add(student);
  }

  public void removeStudent(String studentId) {
      for(Student student : students){
            if(student.getStudentId().equals(studentId)){
                  students.remove(student);
            }
      }
  }

  public Student searchStudentById(String studentId) {
      for(Student student : students){
            if(student.getStudentId().equals(studentId)){
                  return student;
            }
      }
      return null;
  }

  public List<Student> getAllStudents() {
      return students;
  }

  public boolean borrowBook(Book book, Student student) {
      if(book.getIsBorrowed()){
            return false;
      }

      Date loanDate=new Date();
      Calendar calendar= Calendar.getInstance();
      calendar.setTime(loanDate);
      calendar.add(Calendar.DAY_OF_MONTH,10);
      Date dueDate = calendar.getTime();
      book.borrowBook();
      Loan loan=new Loan(book,student,loanDate,dueDate);
      loans.add(loan);
      return true;
  }


  public boolean returnBook(Book book) {
      for(Loan loan :loans){
            if(loan.getBook().equals(book)){
                  loans.remove(loan);
                  loan.getBook().returnBook();
                  return true;
            }
      }
      return false;
  }

  public Book getBorrowedBooksByStudent(String studentId) {
      for(Loan loan : loans){
            if(loan.getStudent().studentId.equals(studentId)){
                  return loan.getBook();
            }
      }
      return null;
  }

  public void  getBooksByCategory(String categoryName) {
      /*for(Category category : categories){
            if(category.getName().equals(categoryName)){

            }
      } */
         // TODO: Implement method 'getStudentsByMajor'.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentsByMajor'");

  }

  public Student getStudentsByMajor(String major) {
      for(Student student :students){
            if(student.getMajor().equals(major)){
                  return student;
            }
      }
      return null;
  }
}

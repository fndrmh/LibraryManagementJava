package model;

import java.util.Date;

public class Loan {
  private Book book;
  private Student student;
  private Date loanDate;
  private Date dueDate;


  public void getBook     (Book book)          {this.book=book;}
  public void getStudent  (Student student) {this.student=student;}
  public void getLoanDate (Date loanDate)  {this.loanDate=loanDate;}
  public void getDueDate  (Date dueDate)    {this.dueDate=dueDate;}

}

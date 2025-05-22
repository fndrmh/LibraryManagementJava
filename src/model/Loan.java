package model;

import java.util.Date;

import jsonlib.JSONSerializable;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class Loan implements JSONSerializable {
  private Book book;
  private Student student;
  private Date loanDate;
  private Date dueDate;

  public Loan(Book book, Student student, Date loanDate, Date dueDate) {
    this.book = book;
    this.student = student;
    this.loanDate = loanDate;
    this.dueDate = dueDate;
  }

  // Seterr
  public void setBook(Book book) {
    this.book = book;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void setLoanDate(Date loanDate) {
    this.loanDate = loanDate;
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = dueDate;
  }

  // getter
  public Book getBook() {
    return this.book;
  }

  public Student getStudent() {
    return this.student;
  }

  public Date getLoanDate() {
    return this.loanDate;
  }

  public Date getDueDate() {
    return this.dueDate;
  }

  @Override
  public JSONObject serialize() {
    // TODO: Implement method 'serialize' for Loan.
    throw new UnsupportedOperationException("Unimplemented method 'serialize' for Loan");
  }

  public static Loan deserialize(JSONDict json) {
    // TODO: Implemented method 'deserialize' for Loan
    throw new UnsupportedOperationException("Unimplemented method 'deserialize' for Loan");
  }

}

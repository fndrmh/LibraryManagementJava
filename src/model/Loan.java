package model;

import java.util.Date;
import java.util.Objects;

import jsonlib.JSONSerializableFactory;
import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;
import jsonlib.types.JSONNumber;

public class Loan extends BaseModel {
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
  public String getDisplayName() {
    return String.format("%s borrowed %s", student.getDisplayName(), book.getDisplayName());
  }

  @Override
  public JSONObject serialize() {
    JSONDict result = new JSONDict();

    result.put("class", JSONObject.fromString("Loan"));
    result.put("book", book.serialize());
    result.put("student", student.serialize());

    result.put("loanDate", new JSONNumber<Long>(loanDate.getTime()));
    result.put("dueDate", new JSONNumber<Long>(dueDate.getTime()));
    return result;
  }

  public static Loan deserialize(JSONDict json) {
    JSONNumber<Long> loanDateValue = (JSONNumber<Long>) json.get("loanDate");
    JSONNumber<Long> dueDateValue = (JSONNumber<Long>) json.get("dueDate");

    Book book = (Book) JSONSerializableFactory.deserialize((JSONDict) json.get("book"));
    Student student = (Student) JSONSerializableFactory.deserialize((JSONDict) json.get("student"));

    return new Loan(book, student, new Date(loanDateValue.getValue()), new Date(dueDateValue.getValue()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(book, student, loanDate, dueDate);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Loan))
      return false;

    Loan other = (Loan) obj;
    return this.student.equals(other.student) && this.book.equals(other.book) && this.loanDate.equals(other.loanDate)
        && this.dueDate.equals(other.dueDate);
  }
}

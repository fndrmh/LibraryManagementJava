package model;

public abstract class Student extends BaseModel {
  protected String studentId;
  protected String firstName;
  protected String lastName;
  protected String major;

  public Student(String studentId, String firstName, String lastName, String major) {
    this.studentId = studentId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.major = major;
  }

  public abstract void getStudentDetails();

  // Setter
  public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  // Getter
  public String getStudentId() {
    return this.studentId;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getMajor() {
    return this.major;
  }

  public String getType() {
    return this.getClass().getSimpleName().equals("GraduateStudent") ? "Graduate" : "Undergraduate";
  }

  @Override
  public String getDisplayName() {
    return String.format("%s %s (%s)", firstName, lastName, studentId);
  }
}

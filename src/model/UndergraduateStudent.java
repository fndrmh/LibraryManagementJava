package model;

import jsonlib.types.JSONObject;
import jsonlib.types.JSONDict;

public class UndergraduateStudent extends Student {
  private int enrollmentYear;

  @Override
  public void getStudentDetails() {
    // TODO: Implement method 'getStudentDetails' for UndergraduateStudent.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentDetails'");
  }

  public UndergraduateStudent(String studentId, String firstName, String lastName, String major, int enrollmentYear) {
    super(studentId, firstName, lastName, major);
    this.enrollmentYear = enrollmentYear;
  }

  // Getter
  public int getEnrollmentYear() {
    return this.enrollmentYear;
  }

  // Setter
  public void setEnrollmentYear(int enrollmentYear) {
    this.enrollmentYear = enrollmentYear;
  }

  @Override
  public JSONObject serialize() {
    // TODO: Implemented method 'serialize' for UndergraduateStudent
    throw new UnsupportedOperationException("Unimplemented method 'serialize' for UndergraduateStudent");
  }

  public static UndergraduateStudent deserialize(JSONDict json) {
    // TODO: Implemented method 'deserialize' for UndergraduateStudent 
    throw new UnsupportedOperationException("Unimplemented method 'deserialize' for UndergraduateStudent");
  }

}

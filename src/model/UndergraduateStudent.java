package model;

import jsonlib.types.JSONObject;

import java.util.Objects;

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
  public String toString() {
    return String.format("%s %s\n\tID: %s\n\tMajor: %s\n\tEnrollment Year: %d\n", firstName, lastName, studentId, major,
        enrollmentYear);
  }

  @Override
  public JSONObject serialize() {
    JSONDict result = new JSONDict();

    result.put("class", JSONObject.fromString("UndergraduateStudent"));

    result.put("studentId", JSONObject.fromString(studentId));
    result.put("firstName", JSONObject.fromString(firstName));
    result.put("lastName", JSONObject.fromString(lastName));
    result.put("major", JSONObject.fromString(major));

    result.put("enrollmentYear", JSONObject.fromNumber(enrollmentYear));
    return result;
  }

  public static UndergraduateStudent deserialize(JSONDict json) {
    return new UndergraduateStudent(json.getString("studentId"), json.getString("firstName"),
        json.getString("lastName"), json.getString("major"), json.getInteger("enrollmentYear"));
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentId, firstName, lastName, major, enrollmentYear);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof UndergraduateStudent))
      return false;

    UndergraduateStudent other = (UndergraduateStudent) obj;

    return this.studentId.equals(other.studentId) && this.firstName.equals(other.firstName)
        && this.lastName.equals(other.lastName) && this.major.equals(other.major)
        && this.enrollmentYear == other.enrollmentYear;
  }
}

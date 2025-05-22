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

}

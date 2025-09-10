package model;

import jsonlib.types.JSONObject;

import java.util.Objects;

import jsonlib.types.JSONDict;

public class GraduateStudent extends Student {
  private String supervisor;
  private String thesisTitle;

  @Override
  public void getStudentDetails() {
    // TODO: Implement method 'getStudentDetails' for GraduateStudent.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentDetails'");
  }

  public GraduateStudent(String studentId, String firstName, String lastName, String major, String supervisor,
      String thesisTitle) {
    super(studentId, firstName, lastName, major);
    this.supervisor = supervisor;
    this.thesisTitle = thesisTitle;
  }

  // Getter
  public String getSupervisor() {
    return supervisor;
  }

  public String getThesisTitle() {
    return thesisTitle;
  }

  // Setter
  public void setSupervisor(String supervisor) {
    this.supervisor = supervisor;
  }

  public void setThesisTitle(String thesisTitle) {
    this.thesisTitle = thesisTitle;
  }

  @Override
  public String toString() {
    return String.format("%s %s\n\tID: %s\n\tMajor: %s\n\tSupervisor: %s\n\tThesis Title: %s\n", firstName, lastName,
        studentId, major, supervisor, thesisTitle);
  }

  @Override
  public JSONObject serialize() {
    JSONDict result = new JSONDict();

    result.put("class", JSONObject.fromString("GraduateStudent"));

    result.put("studentId", JSONObject.fromString(studentId));
    result.put("firstName", JSONObject.fromString(firstName));
    result.put("lastName", JSONObject.fromString(lastName));
    result.put("major", JSONObject.fromString(major));

    result.put("supervisor", JSONObject.fromString(supervisor));
    result.put("thesisTitle", JSONObject.fromString(thesisTitle));

    return result;
  }

  public static GraduateStudent deserialize(JSONDict json) {
    return new GraduateStudent(json.getString("studentId"), json.getString("firstName"), json.getString("lastName"),
        json.getString("major"), json.getString("supervisor"), json.getString("thesisTitle"));
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentId, firstName, lastName, major, supervisor, thesisTitle);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof GraduateStudent))
      return false;

    GraduateStudent other = (GraduateStudent) obj;

    return this.studentId.equals(other.studentId) && this.firstName.equals(other.firstName)
        && this.lastName.equals(other.lastName) && this.major.equals(other.major)
        && this.supervisor.equals(other.supervisor) && this.thesisTitle.equals(other.thesisTitle);
  }
}

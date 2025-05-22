package model;

import jsonlib.types.JSONObject;
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
  public JSONObject serialize() {
    // TODO: Implemented method 'serialize' for GraduateStudent
    throw new UnsupportedOperationException("Unimplemented method 'serialize' for GraduateStudent");
  }

  public static GraduateStudent deserialize(JSONDict json) {
    // TODO: Implemented method 'deserialize' for GraduateStudent
    throw new UnsupportedOperationException("Unimplemented method 'deserialize' for GraduateStudent");
  }
}

package model;

public class GraduateStudent extends Student {
  private String supervisor;
  private String thesisTitle;
  @Override
  public void getStudentDetails() {
    // TODO: Implement method 'getStudentDetails' for GraduateStudent.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentDetails'");
  }
public GraduateStudent(String studentId,String firstName,String lastName,String major,String superString,String theString){
      super(studentId, firstName, lastName, major);
      this.supervisor=supervisor;
      this.thesisTitle=thesisTitle;
}
//Getter
public String getSupervisor()  {return supervisor;}
public String getThesisTitle() {return thesisTitle;}
//Setter
public void setSupervisor (String supervisor)  {this.supervisor=supervisor;}
public void setThesisTitle(String thesisTitle) {this.thesisTitle=thesisTitle;}
}


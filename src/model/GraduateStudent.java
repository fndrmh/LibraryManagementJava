package model;

public class GraduateStudent extends Student {
  private String supervisor;
  private String thesisTitle;
  @Override
  public void getStudentDetails() {
    // TODO: Implement method 'getStudentDetails' for GraduateStudent.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentDetails'");
  }
public GraduateStudent(String studentId,String firstName,String lastName,String major,String supervisor,String thesisTitle)
{
      super(studentId, firstName, lastName, major);
      this.supervisor=supervisor;
      this.thesisTitle=thesisTitle;
}
}

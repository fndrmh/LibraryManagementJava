package model;

public class UndergraduateStudent extends Student {
  private int enrollmentYear;

  @Override
  public void getStudentDetails() {
    // TODO: Implement method 'getStudentDetails' for UndergraduateStudent.
    throw new UnsupportedOperationException("Unimplemented method 'getStudentDetails'");
  }

    UndergraduateStudent(String studentId,String firstName,String lastName,String major,int enrollmentYear)
    {
        super(studentId,firstName,lastName,major);
        this.enrollmentYear=enrollmentYear;
    }

}

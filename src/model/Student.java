package model;

public abstract class Student {
  protected  String studentId;
  protected  String firstName;
  protected  String lastName;
  protected  String major;
Student(String studentId,String firstName,String lastName,String major)
{
      this.studentId=studentId;
      this.firstName=firstName;
      this.lastName=lastName;
      this.major=major;
}
  public abstract void getStudentDetails();
}
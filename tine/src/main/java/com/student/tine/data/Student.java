package com.student.tine.data;

public class Student {
    private String studentNumber;
    private String firstName;
    private String lastName;

    public Student(){
        this.studentNumber = "";
        this.firstName = "";
        this.lastName = "";
    }

    public Student(String studentNumber, String firstName, String lastName) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

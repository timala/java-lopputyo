package com.student.tine.data;

public class Course {
    private String courseCode;
    private String courseName;
    private String teacher;

    public Course(){
        this.courseCode = "";
        this.courseName = "";
        this.teacher = "";
    }

    public Course(String courseCode, String courseName, String teacher) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.teacher = teacher;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}

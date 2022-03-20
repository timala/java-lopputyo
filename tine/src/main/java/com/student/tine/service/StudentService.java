package com.student.tine.service;

import com.student.tine.data.Course;
import com.student.tine.data.Student;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    //FileServicet liitetään
    StudentFileService sfs = new StudentFileService();
    CourseFileService cfs = new CourseFileService();
    CoursesAndStudentsFileService casfs = new CoursesAndStudentsFileService();

    //Luodaan students ja courses -nimiset listat
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    //Constructor kutsuu StudentFileServiceä
    public StudentService(){
        try {
            sfs.createFile();
            students = sfs.readStudentsFromFile();  //Tallettaa opiskelijoiden tiedot tiedostosta students -listaan
            cfs.createFile();
            courses = cfs.readCoursesFromFile();
            casfs.createFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student){
        students.add(student);      //Lisää opiskelijan students -listaan
        try {
            sfs.writeStudentToFile(student);    //Kirjoittaa opiskelijan tiedot tiedostoon
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCourse(Course course){
        courses.add(course);
        try {
            cfs.writeCourseToFile(course);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public List<Student> getStudentById(String id){
        List<Student> foundStudent = new ArrayList<>();

        for (Student s : students) {
            if(s.getStudentNumber().equals(id)) {
                foundStudent.add(s);
            }
        }
        return foundStudent;
    }

    public List<Course> getCourses(){
        return new ArrayList<>(courses);
    }

    public String addStudentToCourse( String courseCode, String studentNumber){
        Course c = new Course();
        Student s = new Student();

        for ( Course course : courses) {
            if( course.getCourseCode().equals(courseCode)){ c = course; }
        }
        if(c.getCourseName().equals("")){ return "Kurssia ei löytynyt";}

        for ( Student student : students) {
            if( student.getStudentNumber().equals(studentNumber)){ s = student; }
        }
        if(s.getFirstName().equals("")){ return "Opiskelijaa ei löytynyt"; }

        try {
            casfs.writeCoursesAndStudentsToFile(s,c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Lisäys onnistui";
}
}

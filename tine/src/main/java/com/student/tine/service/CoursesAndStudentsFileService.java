package com.student.tine.service;

import com.student.tine.data.Course;
import com.student.tine.data.Student;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class CoursesAndStudentsFileService {

    File f = new File("coursesAndStudents.txt");

    //Luo tiedoston, jos ei ole vielä olemassa
    public void createFile() throws IOException {
        if (f.createNewFile()) {
            System.out.println("File created: " + f.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    //Kirjoittaa kurssien ja opiskelijoiden tiedot tiedostoon
    public void writeCoursesAndStudentsToFile(Student student, Course course) throws IOException {
        FileWriter fw = new FileWriter( f, true);

        fw.write(course.getCourseCode() + "---" + course.getCourseName() + "---" + course.getTeacher() +
                "---" + student.getStudentNumber() + "---" + student.getLastName() + "---" + student.getFirstName() +
                System.lineSeparator() );

        fw.close();
    }
}

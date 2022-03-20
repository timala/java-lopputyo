package com.student.tine.service;

import com.student.tine.data.Course;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CourseFileService {

    File f = new File("courses.txt");

    //Luo tiedoston, jos ei ole vielä olemassa
    public void createFile() throws IOException {
        if (f.createNewFile()) {
            System.out.println("File created: " + f.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    //Kirjoittaa kurssien tiedot tiedostoon
    public void writeCourseToFile(Course course) throws IOException {
        FileWriter fw = new FileWriter( f, true);

        fw.write(course.getCourseCode() + "---" + course.getCourseName() + "---" + course.getTeacher() + System.lineSeparator() );

        fw.close();
    }

    //Lukee kurssien tiedot tiedostosta
    public List<Course> readCoursesFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("courses.txt"));
        List<Course> courses = new ArrayList<>();     //Luo uuden courses-nimisen listan

        while (sc.hasNext()){
            String row = sc.nextLine();     //Tallentaa rivin row-muuttujaan
            String[] info = row.split("---");   //Tallettaa tiedot rivistä taulukkoon, --- erottaa tiedot toisistaan
            Course c = new Course(info[0], info[1], info[2]); //Tallettaa tiedot Course-tyypin olioon
            courses.add(c);    //Lisää olion students-listaan
        }

        sc.close();
        return courses;
    }
}

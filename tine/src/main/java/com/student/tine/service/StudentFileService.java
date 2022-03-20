package com.student.tine.service;

import com.student.tine.data.Student;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentFileService {

    File f = new File("students.txt");

    //Luo tiedoston, jos ei ole vielä olemassa
    public void createFile() throws IOException {
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
            } else {
                System.out.println("File already exists.");
            }
    }

    //Kirjoittaa opiskelijoiden tiedot tiedostoon
    public void writeStudentToFile(Student student) throws IOException {
        FileWriter fw = new FileWriter( f, true);

        fw.write( student.getStudentNumber() + "---" + student.getFirstName() + "---" + student.getLastName() + System.lineSeparator() );

        fw.close();
    }

    //Lukee opiskelijoiden tiedot tiedostosta
    public List<Student> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("students.txt"));
        List<Student> students = new ArrayList<>();     //Luo uuden students-nimisen listan

        while (sc.hasNext()){
            String row = sc.nextLine();     //Tallentaa rivin row-muuttujaan
            String[] info = row.split("---");   //Tallettaa tiedot rivistä taulukkoon, --- erottaa tiedot toisistaan
            Student s = new Student(info[0], info[1], info[2]); //Tallettaa tiedot Student-tyypin olioon
            students.add(s);    //Lisää olion students-listaan
        }

        sc.close();
        return students;
    }
}

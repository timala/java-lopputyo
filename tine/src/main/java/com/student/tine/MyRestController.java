package com.student.tine;

import com.student.tine.data.Course;
import com.student.tine.data.Student;
import com.student.tine.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    StudentService myStudentService;

    //Hakee kaikkien opiskelijoiden tiedot
    @GetMapping("students")
    public List<Student> getStudents(){
        return myStudentService.getStudents();
    }

    //Hakee tietyn opiskelijan id:n perusteella
    @GetMapping("students/{id}")
    public List<Student> getStudentById(@PathVariable String id){
        return myStudentService.getStudentById(id);
    }

    //Lisää opiskelijan json-muodossa
    @PostMapping("addStudents")
    public String addStudent(@RequestBody Student student){
        myStudentService.addStudent(student);
        return "Lisäys onnistui";
    }

    //Lisää opiskelijan Localhost:8080 kautta (index.html kutsuu tätä)
    @PostMapping("addStudent")
    public String addStudent(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName){
        myStudentService.addStudent( new Student( id, firstName, lastName ) );
        return "Lisäys onnistui";
    }

    //Hakee kaikkien kurssien tiedot
    @GetMapping("courses")
    public List<Course> getCourses(){
        return myStudentService.getCourses();
    }

    //Lisää kurssin
    @PostMapping("addCourse")
    public String addCourse(@RequestParam String courseCode, @RequestParam String courseName, @RequestParam String teacher){
        myStudentService.addCourse( new Course( courseCode, courseName, teacher));
        return "Lisäys onnistui";
    }

    //Lisää tietyn opiskelijan tietylle kurssille kurssikoodin ja opiskelijanumeron perusteella
    @PostMapping("addStudentToCourse")
    public String addStudentToCourse(@RequestParam String courseCode, @RequestParam String studentNumber){
        return myStudentService.addStudentToCourse( courseCode, studentNumber );
        //return "Lisäys onnistui";
    }

}

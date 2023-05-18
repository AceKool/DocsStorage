package com.docsstorage.docsstorage.Controllers;

import com.docsstorage.docsstorage.Exceptions.StudentNotFoundException;
import com.docsstorage.docsstorage.Exceptions.CustomNotFoundException;
import com.docsstorage.docsstorage.Models.Student;
import com.docsstorage.docsstorage.Models.Object;
import com.docsstorage.docsstorage.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Student student){
    studentService.saveStudent(student);
    return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
        try{
            Student student =studentService.getStudentById(id);
            return ResponseEntity.ok(student);
        }
        catch(StudentNotFoundException ex){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that student with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer id){
        try{
            Student _student = studentService.getStudentById(id);
            _student.updateStudent(student);
            studentService.saveStudent(_student);
            return ResponseEntity.ok(student);
        }
        catch (StudentNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that student with ID: " + id + " doesn't exist...");
        }
    }
}

package com.docsstorage.docsstorage.Services;

import com.docsstorage.docsstorage.Exceptions.StudentNotFoundException;
import com.docsstorage.docsstorage.Models.Student;
import com.docsstorage.docsstorage.Repos.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public void deleteStudentById(Integer id){
        Student student = getStudentById(id);
        studentRepo.delete(student);
    }
}

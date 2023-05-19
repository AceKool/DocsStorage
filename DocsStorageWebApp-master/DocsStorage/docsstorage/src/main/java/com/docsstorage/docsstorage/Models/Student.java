package com.docsstorage.docsstorage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fullName")
    private String fullName;
    @Column(name = "studentId")
    private String studentId;

    public void updateStudent(Student student){
    if(student.fullName != null)    { this.fullName = student.fullName; }

    if(student.studentId != null)      { this.studentId = student.studentId; }

    if(student.orders != null)       {this.orders = student.orders; }
    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Order> orders;

}

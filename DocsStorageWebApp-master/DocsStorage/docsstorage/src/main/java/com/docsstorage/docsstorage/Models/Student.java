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

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "studentId")
    private String studentId;

    public void updateClient(Client client){
    if(student.firstName != null)    { this.firstName = student.firstName; }

    if(student.lastName != null)     { this.lastName = student.lastName; }

    if(student.studentId != null)      { this.studentId = student.studentId; }

    if(student.orders != null)       {this.orders = student.orders; }
    }

    // Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Order> orders;

}

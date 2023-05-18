package com.docsstorage.docsstorage.Repos;

import com.docsstorage.docsstorage.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByFirstName(String firstName);
}

package com.docsstorage.docsstorage.Repos;

import com.docsstorage.docsstorage.Models.Object;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectRepo extends JpaRepository<Object, Integer> {
    List<Object> findByName(String name);
}

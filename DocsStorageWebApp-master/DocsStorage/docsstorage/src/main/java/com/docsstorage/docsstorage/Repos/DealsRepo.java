package com.docsstorage.docsstorage.Repos;

import com.docsstorage.docsstorage.Models.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface DealRepo extends JpaRepository<Deal, Integer> {
    List<Deal> findByDate(Date date_of_order);
}
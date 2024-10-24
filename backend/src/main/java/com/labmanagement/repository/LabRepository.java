package com.labmanagement.repository;

import com.labmanagement.entity.Lab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LabRepository extends JpaRepository<Lab, Long> {
    @Query("SELECT l FROM Lab l LEFT JOIN FETCH l.devices")
    List<Lab> findAllWithDevices();
}
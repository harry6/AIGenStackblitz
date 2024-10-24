package com.labmanagement.repository;

import com.labmanagement.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByLabId(Long labId);
}
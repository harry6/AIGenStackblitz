package com.labmanagement.service;

import com.labmanagement.entity.Device;
import com.labmanagement.repository.DeviceRepository;
import com.labmanagement.dto.DeviceDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<DeviceDTO> getDevicesByLabId(Long labId) {
        return deviceRepository.findByLabId(labId).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public DeviceDTO createDevice(Device device) {
        return convertToDTO(deviceRepository.save(device));
    }

    private DeviceDTO convertToDTO(Device device) {
        DeviceDTO dto = new DeviceDTO();
        dto.setId(device.getId());
        dto.setName(device.getName());
        dto.setStatus(device.getStatus());
        dto.setLabId(device.getLab().getId());
        return dto;
    }
}
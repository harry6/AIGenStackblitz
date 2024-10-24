package com.labmanagement.service;

import com.labmanagement.entity.Lab;
import com.labmanagement.repository.LabRepository;
import com.labmanagement.dto.LabDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LabService {
    private final LabRepository labRepository;

    public LabService(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    public List<LabDTO> getAllLabs() {
        return labRepository.findAllWithDevices().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public LabDTO createLab(Lab lab) {
        return convertToDTO(labRepository.save(lab));
    }

    private LabDTO convertToDTO(Lab lab) {
        LabDTO dto = new LabDTO();
        dto.setId(lab.getId());
        dto.setName(lab.getName());
        dto.setLocation(lab.getLocation());
        dto.setDevices(lab.getDevices().stream()
            .map(device -> {
                DeviceDTO deviceDTO = new DeviceDTO();
                deviceDTO.setId(device.getId());
                deviceDTO.setName(device.getName());
                deviceDTO.setStatus(device.getStatus());
                deviceDTO.setLabId(lab.getId());
                return deviceDTO;
            })
            .collect(Collectors.toList()));
        return dto;
    }
}
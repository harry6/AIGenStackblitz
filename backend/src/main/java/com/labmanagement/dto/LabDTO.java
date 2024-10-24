package com.labmanagement.dto;

import lombok.Data;
import java.util.List;

@Data
public class LabDTO {
    private Long id;
    private String name;
    private String location;
    private List<DeviceDTO> devices;
}
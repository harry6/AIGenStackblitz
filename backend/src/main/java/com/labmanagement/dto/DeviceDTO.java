package com.labmanagement.dto;

import lombok.Data;
import com.labmanagement.entity.Device.Status;

@Data
public class DeviceDTO {
    private Long id;
    private String name;
    private Status status;
    private Long labId;
}
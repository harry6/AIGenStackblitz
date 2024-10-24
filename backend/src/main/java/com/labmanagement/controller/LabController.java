package com.labmanagement.controller;

import com.labmanagement.dto.LabDTO;
import com.labmanagement.service.LabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/labs")
@CrossOrigin(origins = "*")
public class LabController {
    private final LabService labService;

    public LabController(LabService labService) {
        this.labService = labService;
    }

    @GetMapping
    public ResponseEntity<List<LabDTO>> getAllLabs() {
        return ResponseEntity.ok(labService.getAllLabs());
    }
}
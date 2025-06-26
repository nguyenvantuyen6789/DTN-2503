package com.example.elearning.demo_elearning_api.controller;

import com.example.elearning.demo_elearning_api.dto.CertificateDTO;
import com.example.elearning.demo_elearning_api.service.CertificateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/certificates")
public class CertificateController {
    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @GetMapping
    public List<CertificateDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{courseId}")
    public List<CertificateDTO> getByCourse(@PathVariable Long courseId) {
        return service.getByCourse(courseId);
    }

    @PostMapping("/{courseId}")
    public CertificateDTO create(@PathVariable Long courseId, @RequestBody CertificateDTO dto) {
        return service.create(courseId, dto.getType());
    }
}
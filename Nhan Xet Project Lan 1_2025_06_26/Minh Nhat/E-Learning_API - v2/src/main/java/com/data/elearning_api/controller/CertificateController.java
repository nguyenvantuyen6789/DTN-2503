package com.data.elearning_api.controller;

import com.data.elearning_api.dto.CertificateCreateDTO;
import com.data.elearning_api.dto.CertificateDTO;
import com.data.elearning_api.entity.Account;
import com.data.elearning_api.entity.Certificate;
import com.data.elearning_api.entity.Course;
import com.data.elearning_api.repository.AccountRepository;
import com.data.elearning_api.repository.CertificateRepository;
import com.data.elearning_api.repository.CourseRepository;
import com.data.elearning_api.service.CertificateService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/certificates")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public ResponseEntity<?> getAllCertificates() {
        List<Certificate> certificates = certificateService.getAll();

        List<CertificateDTO> certificateDTOS = new ArrayList<>();

        for (Certificate certificate : certificates) {
            CertificateDTO dto = new CertificateDTO();
            dto.setId(certificate.getId());
            dto.setType(certificate.getType());
            dto.setScore(certificate.getScore());
            dto.setIssueDate(certificate.getIssueDate());
            dto.setAccountId(certificate.getAccount().getId());
            dto.setCourseId(certificate.getCourse().getId());
            certificateDTOS.add(dto);
        }

        return new ResponseEntity<>(certificateDTOS, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCertificateByCourse(@PathVariable int courseId) {
        List<Certificate> certificates = certificateService.getByCourseId(courseId);

        List<CertificateDTO> certificateDTOS = new ArrayList<>();

        for (Certificate certificate : certificates) {
            CertificateDTO dto = new CertificateDTO();
            dto.setId(certificate.getId());
            dto.setType(certificate.getType());
            dto.setScore(certificate.getScore());
            dto.setIssueDate(certificate.getIssueDate());
            dto.setAccountId(certificate.getAccount().getId());
            dto.setCourseId(certificate.getCourse().getId());
            certificateDTOS.add(dto);
        }

        return new ResponseEntity<>(certificateDTOS, HttpStatus.OK);
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<?> createCertificate(@PathVariable int courseId,
                                               @RequestBody CertificateCreateDTO dto) {
        Certificate created = certificateService.create(courseId, dto);

        if (created == null) {
            return new ResponseEntity<>("Invalid courseId or accountId", HttpStatus.BAD_REQUEST);
        }

        CertificateDTO responseDTO = new CertificateDTO();
        responseDTO.setId(created.getId());
        responseDTO.setType(created.getType());
        responseDTO.setScore(created.getScore());
        responseDTO.setIssueDate(created.getIssueDate());
        responseDTO.setAccountId(created.getAccount().getId());
        responseDTO.setCourseId(created.getCourse().getId());

        return new ResponseEntity<>("Create Success", HttpStatus.CREATED);
    }
}
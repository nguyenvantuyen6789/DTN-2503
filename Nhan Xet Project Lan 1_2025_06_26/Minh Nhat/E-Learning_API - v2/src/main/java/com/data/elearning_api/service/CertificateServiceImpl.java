package com.data.elearning_api.service;

import com.data.elearning_api.dto.CertificateCreateDTO;
import com.data.elearning_api.entity.*;
import com.data.elearning_api.repository.AccountRepository;
import com.data.elearning_api.repository.CategoryRepository;
import com.data.elearning_api.repository.CertificateRepository;
import com.data.elearning_api.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateRepository certificateRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private AccountRepository accountRepo;

    @Override
    public List<Certificate> getAll() {
        List<Certificate> certificates = certificateRepo.findAll();
        return certificates;
    }

    @Override
    public List<Certificate> getByCourseId(int courseId) {
        List<Certificate> certificate = certificateRepo.findByCourseId(courseId);
        return certificate;
    }

    @Override
    public Certificate create(int courseId, CertificateCreateDTO dto) {
        Course course = courseRepo.findById(courseId).orElse(null);
        Account account = accountRepo.findById(dto.getAccountId()).orElse(null);

        if (course == null || account == null) {
            return null;
        }

        Certificate certificate = new Certificate();
        certificate.setCourse(course);
        certificate.setAccount(account);
        certificate.setScore(dto.getScore());
        certificate.setIssueDate(LocalDate.now());

        if (dto.getScore() >= 85) {
            certificate.setType(CertificateType.MASTER);
        } else if (dto.getScore() >= 70) {
            certificate.setType(CertificateType.PROFESSIONAL);
        } else {
            certificate.setType(CertificateType.ASSOCIATE);
        }

        return certificateRepo.save(certificate);
    }
}
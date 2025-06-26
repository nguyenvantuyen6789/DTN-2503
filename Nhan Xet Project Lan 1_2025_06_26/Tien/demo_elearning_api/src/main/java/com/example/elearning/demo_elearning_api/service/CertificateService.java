package com.example.elearning.demo_elearning_api.service;

import com.example.elearning.demo_elearning_api.dto.CertificateDTO;
import com.example.elearning.demo_elearning_api.entity.Certificate;
import com.example.elearning.demo_elearning_api.entity.Course;
import com.example.elearning.demo_elearning_api.repository.CertificateRepository;
import com.example.elearning.demo_elearning_api.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificateService {
    private final CertificateRepository certRepo;
    private final CourseRepository courseRepo;

    public CertificateService(CertificateRepository certRepo, CourseRepository courseRepo) {
        this.certRepo = certRepo;
        this.courseRepo = courseRepo;
    }

    public List<CertificateDTO> getAll() {
        return certRepo.findAll().stream()
                .map(c -> new CertificateDTO(c.getId(), c.getType(),
                        c.getCourse().getId(), c.getCourse().getTitle()))
                .collect(Collectors.toList());
    }

    public List<CertificateDTO> getByCourse(Long courseId) {
        return certRepo.findByCourseId(courseId).stream()
                .map(c -> new CertificateDTO(c.getId(), c.getType(),
                        c.getCourse().getId(), c.getCourse().getTitle()))
                .collect(Collectors.toList());
    }

    public CertificateDTO create(Long courseId, String type) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        Certificate cert = new Certificate(null, type, course);
        cert = certRepo.save(cert);
        return new CertificateDTO(cert.getId(), cert.getType(),
                course.getId(), course.getTitle());
    }
}

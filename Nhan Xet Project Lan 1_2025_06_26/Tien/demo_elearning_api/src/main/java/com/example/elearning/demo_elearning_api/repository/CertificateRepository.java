package com.example.elearning.demo_elearning_api.repository;

import com.example.elearning.demo_elearning_api.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByCourseId(Long courseId);
}
